/**
 * @File: CabinetValidator.java 
 * @Package  com.asiainfo.gim.site.api.validator
 * @Description: 
 * @author luyang
 * @date 2015年8月17日 上午9:38:52 
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

import com.asiainfo.gim.site.domain.Cabinet;

/**
 * @author luyang
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CabinetValidator.Valicator.class)
public @interface CabinetValidator
{
	String message() default "Cabinet bean validate fail!";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	public class Valicator implements ConstraintValidator<CabinetValidator, Cabinet>
	{
		@Context
		private ContainerRequestContext context;
		
		@Override
		public void initialize(CabinetValidator cv)
		{
			
		}

		@Override
		public boolean isValid(Cabinet cabinet, ConstraintValidatorContext cvc)
		{
			if (StringUtils.equals(context.getMethod(), "POST") || StringUtils.equals(context.getMethod(), "PUT"))
			{
				if (StringUtils.isEmpty(cabinet.getName()) || StringUtils.isEmpty(cabinet.getLocationId()))
				{
					return false;
				}
			}
			return true;
		}
		
	}
}
