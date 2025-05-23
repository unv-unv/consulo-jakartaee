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

import com.intellij.java.language.psi.PsiClass;
import com.intellij.javaee.ejb.role.EjbClassRoleEnum;
import com.intellij.javaee.model.xml.ejb.EjbBase;
import consulo.module.Module;
import consulo.module.extension.ModuleExtension;
import consulo.project.Project;
import consulo.util.collection.ContainerUtil;
import consulo.util.lang.Pair;
import consulo.xml.util.xml.ElementPresentationManager;
import consulo.xml.util.xml.GenericValue;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * @author peter
 */
public class EjbCommonModelUtil
{

	public static <T> List<T> collectEjbClasses(
			final EnterpriseBean ejb,
			final boolean includeClass,
			final boolean includeHomeInterfaces,
			final boolean includeComponentInterfaces,
			final Function<Pair<GenericValue<PsiClass>, EjbClassRoleEnum>, T> mapper)
	{
		final ArrayList<T> result = new ArrayList<T>();
		if(includeClass)
		{
			ContainerUtil.addIfNotNull(result, mapper.apply(Pair.create(ejb.getEjbClass(), EjbClassRoleEnum.EJB_CLASS_ROLE_EJB_CLASS)));
		}
		if(ejb instanceof EjbWithHome)
		{
			final EjbWithHome ejbWithHome = (EjbWithHome) ejb;
			if(includeHomeInterfaces)
			{
				ContainerUtil.addIfNotNull(result,mapper.apply(Pair.create(ejbWithHome.getHome(), EjbClassRoleEnum.EJB_CLASS_ROLE_HOME_INTERFACE)));
				ContainerUtil.addIfNotNull(result,mapper.apply(Pair.create(ejbWithHome.getLocalHome(), EjbClassRoleEnum.EJB_CLASS_ROLE_LOCAL_HOME_INTERFACE)));
			}
			if(includeComponentInterfaces)
			{
				ContainerUtil.addIfNotNull(result,mapper.apply(Pair.create(ejbWithHome.getRemote(), EjbClassRoleEnum.EJB_CLASS_ROLE_REMOTE_INTERFACE)));
				ContainerUtil.addIfNotNull(result,mapper.apply(Pair.create(ejbWithHome.getLocal(), EjbClassRoleEnum.EJB_CLASS_ROLE_LOCAL_INTERFACE)));
				if(ejb instanceof SessionBean)
				{
					final SessionBean sessionBean = (SessionBean) ejb;
					if(Boolean.TRUE.equals(sessionBean.getLocalBean().getValue()))
					{
						ContainerUtil.addIfNotNull(result,mapper.apply(Pair.create(sessionBean.getEjbClass(), EjbClassRoleEnum.EJB_CLASS_ROLE_EJB_CLASS)));
					}
					else
					{
						for(GenericValue<PsiClass> genericValue : sessionBean.getBusinessLocals())
						{
							ContainerUtil.addIfNotNull(result,mapper.apply(Pair.create(genericValue, EjbClassRoleEnum.EJB_CLASS_ROLE_BUSINESS_LOCAL_INTERFACE)));
						}
						for(GenericValue<PsiClass> genericValue : sessionBean.getBusinessRemotes())
						{
							ContainerUtil.addIfNotNull(result,mapper.apply(Pair.create(genericValue, EjbClassRoleEnum.EJB_CLASS_ROLE_BUSINESS_REMOTE_INTERFACE)));
						}
						ContainerUtil.addIfNotNull(result,mapper.apply(Pair.create(sessionBean.getServiceEndpoint(), EjbClassRoleEnum.EJB_CLASS_ROLE_SERVICE_ENDPOINT_INTERFACE)));
					}
				}
			}
		}
		if(includeComponentInterfaces && ejb instanceof MessageDrivenBean)
		{
			ContainerUtil.addIfNotNull(result, mapper.apply(Pair.create((((MessageDrivenBean) ejb)).getMessageListenerInterface(), EjbClassRoleEnum.EJB_CLASS_ROLE_LOCAL_INTERFACE)));
		}
		return result;
	}

	public static List<GenericValue<PsiClass>> getEjbClassesReferences(
			EnterpriseBean ejb, boolean includeClass, boolean includeHomeInterfaces, boolean includeComponentInterfaces)
	{
		return collectEjbClasses(ejb, includeClass, includeHomeInterfaces, includeComponentInterfaces, s -> s.getFirst());
	}

	public static List<PsiClass> getEjbClasses(
			EnterpriseBean ejb, boolean includeClass, boolean includeHomeInterfaces, boolean includeComponentInterfaces)
	{
		return collectEjbClasses(ejb, includeClass, includeHomeInterfaces, includeComponentInterfaces, s -> s.getFirst().getValue());
	}

	/*  @NotNull
	  public static <T, V extends Collection<T>> V mapEjbClassRoles(@NotNull final V result,
																	@NotNull final Project project,
																	@Nullable final Module module,
																	@Nullable final EjbFacet facet,
																	@NotNull final Function<EjbClassRole, T> mapper) {
		for (EjbClassRole role : EjbHelper.getEjbHelper().getAllEjbRoles(project)) {
		  if ((module == null || module == role.getModule()) && (facet == null || facet == role.getFacet())) {
			ContainerUtil.addIfNotNull(mapper.apply(role), result);
		  }
		}
		return result;
	  }
		  */
	/*@NotNull
	public static List<Interceptor> getAllInterceptors(@NotNull final Project project, @Nullable final Module module, @Nullable final EjbFacet facet)
	{ */
	/*return mapEjbClassRoles(new ArrayList<Interceptor>(), project, module, facet, new NullableFunction<EjbClassRole, Interceptor>() {
	  public Interceptor fun(final EjbClassRole ejbClassRole) {
        return ejbClassRole.getInterceptor();
      }
    });   */
	/*	return Collections.emptyList();
	}
      */
	@Nonnull
	public static List<EnterpriseBean> getAllEjbs(
			@Nonnull final Project project, @Nullable final Module module, @Nullable final ModuleExtension<?> facet)
	{
    /*return mapEjbClassRoles(new ArrayList<EnterpriseBean>(), project, module, facet, new NullableFunction<EjbClassRole, EnterpriseBean>() {
      public EnterpriseBean fun(final EjbClassRole ejbClassRole) {
        return ejbClassRole.getEnterpriseBean();
      }
    }); */
		return Collections.emptyList();

	}

	public static List<EnterpriseBean> getAllEjbs(@Nonnull final Project project)
	{
		return getAllEjbs(project, null, null);
	}

	@Nonnull
	public static EnterpriseBean getMergedEnterpriseBean(@Nonnull final EjbBase base)
	{
		final Module module = base.getModule();
		if(module != null)
		{
			final EnterpriseBean bean = ElementPresentationManager.findByName(getAllEjbs(module.getProject(), module, null), base.getEjbName().getValue());
			if(bean != null)
			{
				return bean;
			}
		}
		return base;
	}
}
