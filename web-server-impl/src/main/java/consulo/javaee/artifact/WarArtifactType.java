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

package consulo.javaee.artifact;

import com.intellij.javaee.J2EEBundle;
import consulo.annotation.component.ExtensionImpl;
import consulo.jakartaee.webServer.impl.ui.packaging.WebApplicationArtifactType;
import consulo.compiler.artifact.ArtifactTemplate;
import consulo.compiler.artifact.ArtifactUtil;
import consulo.compiler.artifact.element.CompositePackagingElement;
import consulo.compiler.artifact.element.PackagingElementFactory;
import consulo.compiler.artifact.element.PackagingElementResolvingContext;
import consulo.compiler.artifact.element.ZipArchivePackagingElement;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

/**
 * @author VISTALL
 * @since 07.11.13.
 */
@ExtensionImpl
public class WarArtifactType extends WebApplicationArtifactType
{
	public static WarArtifactType getInstance()
	{
		return EP_NAME.findExtension(WarArtifactType.class);
	}

	public WarArtifactType()
	{
		super("war", J2EEBundle.message("war.artifact.name"));
	}

	@Nonnull
	@Override
	public List<? extends ArtifactTemplate> getNewArtifactTemplates(@Nonnull PackagingElementResolvingContext context)
	{
		return Collections.singletonList(new WarArtifactTemplate(context));
	}

	@Nonnull
	@Override
	public CompositePackagingElement<?> createRootElement(@Nonnull PackagingElementFactory factory, @Nonnull String s)
	{
		return new ZipArchivePackagingElement(ArtifactUtil.suggestArtifactFileName(s) + ".war");
	}
}
