/*
 * Copyright 2000-2007 JetBrains s.r.o.
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

package consulo.jakartaee.webServer.impl;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import consulo.jakartaee.webServer.impl.appServerIntegrations.AppServerIntegration;

/**
 * author: lesya
 */
public class AppServerIntegrationsManager
{
	public static final AppServerIntegrationsManager ourInstance = new AppServerIntegrationsManager();

	public static AppServerIntegrationsManager getInstance()
	{
		return ourInstance;
	}

	public <T extends AppServerIntegration> T getIntegration(@Nonnull Class<T> aClass)
	{
		return AppServerIntegration.EXTENSION_POINT.findExtension(aClass);
	}

	@Nullable
	public AppServerIntegration findIntegrationByName(String name)
	{
		for(AppServerIntegration integration : getAllIntegrations())
		{
			if(name.equals(integration.getPresentableName()))
			{
				return integration;
			}
		}
		return null;
	}

	public AppServerIntegration[] getAllIntegrations()
	{
		return AppServerIntegration.EXTENSION_POINT.getExtensions();
	}
}
