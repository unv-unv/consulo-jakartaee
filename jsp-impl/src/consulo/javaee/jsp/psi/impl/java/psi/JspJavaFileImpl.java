/*
 * Copyright 2013 must-be.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package consulo.javaee.jsp.psi.impl.java.psi;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiJavaCodeReferenceElement;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.impl.PsiImplUtil;
import com.intellij.psi.impl.source.PsiJavaFileBaseImpl;
import com.intellij.util.ArrayUtil;
import consulo.annotations.RequiredReadAction;
import consulo.javaee.jsp.JspFileType;
import consulo.javaee.jsp.psi.impl.java.JspJavaStubElements;

/**
 * @author VISTALL
 * @since 08.11.13.
 */
public class JspJavaFileImpl extends PsiJavaFileBaseImpl implements PsiJavaFile
{
	private static final String[] ourImplicityImports = {
			"java.lang",
			"javax.servlet",
			"javax.servlet.jsp",
			"javax.servlet.http"
	};

	private JspxImportListImpl myImportList = new JspxImportListImpl(this);

	public JspJavaFileImpl(FileViewProvider viewProvider)
	{
		super(JspJavaStubElements.JAVA_IN_JSP_FILE, JspJavaStubElements.JAVA_IN_JSP_FILE, viewProvider);
	}

	@Nonnull
	@Override
	public PsiClass[] getClasses()
	{
		return findChildrenByClass(PsiClass.class);
	}

	@Nonnull
	@Override
	public String[] getImplicitlyImportedPackages()
	{
		return ourImplicityImports;
	}

	@Override
	@Nonnull
	public PsiJavaCodeReferenceElement[] getImplicitlyImportedPackageReferences()
	{
		return PsiImplUtil.namesToPackageReferences(myManager, getImplicitlyImportedPackages());
	}

	@RequiredReadAction
	@Nullable
	@Override
	public JspxImportListImpl getImportList()
	{
		return myImportList;
	}

	@RequiredReadAction
	@Nonnull
	@Override
	public PsiElement[] getChildren()
	{
		return ArrayUtil.prepend(myImportList, super.getChildren());
	}

	@Nonnull
	@Override
	public FileType getFileType()
	{
		return JspFileType.INSTANCE;
	}
}
