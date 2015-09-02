/**
 * @File: LocationValidator.java 
 * @Package  com.asiainfo.gim.site.api.validator
 * @Description: 
 * @author luyang
 * @date 2015年8月14日 下午2:29:02 
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

import com.asiainfo.gim.site.domain.Location;

/**
 * @author luyang
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LocationValidator.Valicator.class)
public @interface LocationValidator
{
	String message() default "Location bean validate fail!";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	public class Valicator implements ConstraintValidator<LocationValidator, Location>
	{
		@Context
		private ContainerRequestContext context;

		@Override
		public void initialize(LocationValidator lv)
		{
			
		}

		@Override
		public boolean isValid(Location location, ConstraintValidatorContext cvc)
		{
			if (StringUtils.equals(context.getMethod(), "POST") || StringUtils.equals(context.getMethod(), "PUT"))
			{
				if (StringUtils.isEmpty(location.getName()) || location.getDatacenterId() == null)
				{
					return false;
				}
			}
			return true;
		}
		
	}
}
