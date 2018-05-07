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
package com.intellij.javaee.appServerIntegrations;

import java.util.Collection;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.intellij.openapi.roots.libraries.Library;
import consulo.annotations.DeprecationInfo;

@Deprecated
@DeprecationInfo("Not needed. Replaced by SDK")
public interface ApplicationServer {
  String getName();

  @Nullable
  AppServerIntegration getSourceIntegration();

  @Nonnull
  Library getLibrary();

  @Nonnull
  Collection<Library> getFrameworkLibraries();

  ApplicationServerPersistentData getPersistentData();

  boolean isDisposed();

  void setSourceIntegrationName(String name);
}
