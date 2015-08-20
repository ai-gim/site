/**
 * @File: DatacenterValidator.java 
 * @Package  com.asiainfo.gim.site.api.validator
 * @Description: 
 * @author luyang
 * @date 2015年8月12日 下午4:44:33 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.site.api.validator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;

import org.apache.commons.lang.StringUtils;

import com.asiainfo.gim.site.domain.Datacenter;

/**
 * @author luyang
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DatacenterValidator.Valicator.class)
public @interface DatacenterValidator
{
	String message() default "Datacenter bean validate fail!";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	public class Valicator implements ConstraintValidator<DatacenterValidator, Datacenter>
	{
		@Context
		private ContainerRequestContext context;

		@Override
		public void initialize(DatacenterValidator dv)
		{
			
		}

		@Override
		public boolean isValid(Datacenter datacenter, ConstraintValidatorContext cv)
		{
			if (StringUtils.equals(context.getMethod(), "POST") || StringUtils.equals(context.getMethod(), "PUT"))
			{
				if (StringUtils.isEmpty(datacenter.getName()))
				{
					return false;
				}
			}
			return true;
		}
	}
}
