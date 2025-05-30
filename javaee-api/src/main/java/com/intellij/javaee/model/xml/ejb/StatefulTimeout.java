/*
 * Copyright 2000-2009 JetBrains s.r.o.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

// Generated on Wed Apr 29 15:54:26 MSD 2009
// DTD/Schema  :    http://java.sun.com/xml/ns/javaee

package com.intellij.javaee.model.xml.ejb;

import jakarta.annotation.Nonnull;

import com.intellij.javaee.model.enums.TimeUnitType;
import com.intellij.javaee.model.xml.JavaeeDomModelElement;
import consulo.xml.util.xml.GenericDomValue;
import consulo.xml.util.xml.Required;

/**
 * http://java.sun.com/xml/ns/javaee:stateful-timeoutType interface.
 * <pre>
 * <h3>Type http://java.sun.com/xml/ns/javaee:stateful-timeoutType documentation</h3>
 * The stateful-timeoutType represents the amount of time
 * 	a stateful session bean can be idle(not receive any client
 * 	invocations) before it is eligible for removal by the container.
 * </pre>
 */
public interface StatefulTimeout extends JavaeeDomModelElement {

	/**
	 * Returns the value of the timeout child.
	 * <pre>
	 * <h3>Type http://java.sun.com/xml/ns/javaee:xsdPositiveIntegerType documentation</h3>
	 * This type adds an "id" attribute to xsd:positiveInteger.
	 * </pre>
	 * @return the value of the timeout child.
	 */
	@Nonnull
	@Required
	GenericDomValue<Integer> getTimeout();


	/**
	 * Returns the value of the unit child.
	 * @return the value of the unit child.
	 */
	@Nonnull
	@Required
	GenericDomValue<TimeUnitType> getUnit();


}
