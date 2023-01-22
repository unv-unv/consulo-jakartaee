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
package com.intellij.javaee.model.common.ejb;

import com.intellij.java.language.psi.PsiMethod;
import com.intellij.java.language.psi.PsiType;
import com.intellij.javaee.model.common.JavaeeModelElement;
import com.intellij.javaee.model.enums.ResultTypeMapping;
import consulo.xml.util.xml.GenericValue;

import java.util.List;

/**
 * @author peter
 */
public interface Query extends JavaeeModelElement {

  GenericValue<PsiMethod> getQueryMethodName();

  List<? extends GenericValue<PsiType>> getMethodParams();

  GenericValue<ResultTypeMapping> getResultTypeMapping();

  GenericValue<String> getEjbQl();

}
