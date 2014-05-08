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

package com.intellij.javaee.model.xml.ejb;

import com.intellij.psi.PsiClass;
import com.intellij.util.xml.GenericDomValue;

/**
 * Created by IntelliJ IDEA.
 * User: Gregory.Shrago
 * Date: 03.11.2005
 * Time: 17:04:01
 * To change this template use File | Settings | File Templates.
 */

public interface EjbWithHome extends EjbBase, com.intellij.javaee.model.common.ejb.EjbWithHome {

  GenericDomValue<PsiClass> getHome();

  GenericDomValue<PsiClass> getRemote();

  GenericDomValue<PsiClass> getLocalHome();

  GenericDomValue<PsiClass> getLocal();

}