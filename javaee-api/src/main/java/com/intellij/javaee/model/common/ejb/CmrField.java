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

import com.intellij.jam.view.DeleteHandler;
import consulo.xml.util.xml.GenericValue;
import consulo.xml.util.xml.NameValue;
import com.intellij.javaee.model.enums.Multiplicity;
import com.intellij.javaee.model.enums.CmrFieldType;
import com.intellij.javaee.model.common.JavaeeModelElement;

/**
 * @author peter
 */
@DeleteHandler("com.intellij.openapi.module.EjbDeleteHandler")
public interface CmrField extends JavaeeModelElement {
  @NameValue
  GenericValue<String> getCmrFieldName();

  GenericValue<Multiplicity> getMultiplicity();
  GenericValue<CmrFieldType> getCmrFieldType();

  GenericValue<String> getEjbRelationName();
  GenericValue<String> getEjbRelationshipRoleName();
  GenericValue<Boolean> getCascadeDelete();

  boolean isRelationshipSource();

  EntityBean getOppositeEntity();
  CmrField getOppositeField();

  EntityBean getEntityBean();
  String getEntityBeanName();

}
