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

package consulo.javaee.module.extension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.intellij.javaee.model.xml.web.WebApp;
import com.intellij.javaee.web.WebRoot;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import consulo.module.extension.impl.ModuleExtensionImpl;
import consulo.roots.ModuleRootLayer;

/**
 * @author VISTALL
 * @since 07.11.13.
 */
public class JavaWebModuleExtension extends ModuleExtensionImpl<JavaWebModuleExtension> implements JavaEEModuleExtension<JavaWebModuleExtension>
{
	@Nonnull
	public static Collection<JavaWebModuleExtension> getInstances(Module module)
	{
		JavaWebModuleExtension extension = ModuleUtilCore.getExtension(module, JavaWebModuleExtension.class);
		if(extension == null)
		{
			return Collections.emptyList();
		}
		return Collections.singletonList(extension);
	}

	public JavaWebModuleExtension(@Nonnull String id, @Nonnull ModuleRootLayer module)
	{
		super(id, module);
	}

	public List<WebRoot> getWebRoots()
	{
		return Collections.emptyList();
	}

	public List<WebRoot> getWebRoots(boolean includeDependentModules)
	{
		return Collections.emptyList();
	}

	@Nullable
	public WebApp getRoot()
	{
		return null;
	}
}
