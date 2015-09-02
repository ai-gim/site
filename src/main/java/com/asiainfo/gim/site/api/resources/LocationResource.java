/**
 * @File: LocationResource.java 
 * @Package  com.asiainfo.gim.site.api.resources
 * @Description: 
 * @author luyang
 * @date 2015年8月14日 上午11:23:28 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.site.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;

import com.asiainfo.gim.common.rest.exception.ResourceNotFoundException;
import com.asiainfo.gim.common.rest.exception.ValidationException;
import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.site.api.validator.LocationValidator;
import com.asiainfo.gim.site.domain.Location;
import com.asiainfo.gim.site.service.LocationService;

/**
 * @author luyang
 *
 */
@Path("/location")
@Produces(MediaType.APPLICATION_JSON)
public class LocationResource
{
	private LocationService locationService;
	
	@PathParam("id")
	private Integer id;
	
	public LocationResource()
	{
		locationService = SpringContext.getBean(LocationService.class);
	}
	
	@GET
	@Path("{id}")
	public Location getLocation()
	{
		Location location = locationService.findLocationById(id);
		if (location == null)
		{
			throw new ResourceNotFoundException();
		}
		return location;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Location addLocation(@LocationValidator Location location)
	{
		if (location == null)
		{
			throw new ValidationException();
		}
		
		Location locationInDb = locationService.findLocationByName(location.getName());
		if (locationInDb != null)
		{
			throw new ValidationException("Name conflict");
		}
		
		if (location.getId() != null)
		{
			Location locationInDbById = locationService.findLocationById(location.getId());
			if (locationInDbById != null)
			{
				throw new ValidationException("Id conflict");
			}
		}
		
		return locationService.addLocation(location);
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Location updateLocation(@LocationValidator Location location)
	{
		if (location == null)
		{
			throw new ValidationException();
		}
		
		Location locationInDb = locationService.findLocationById(id);
		if (locationInDb == null)
		{
			throw new ResourceNotFoundException();
		}
		
		if (!StringUtils.equals(location.getName(), locationInDb.getName()))
		{
			Location locationInDbByName = locationService.findLocationByName(location.getName());
			if (locationInDbByName != null)
			{
				throw new ValidationException("Name conflict");
			}
		}
		
		location.setId(id);
		
		return locationService.updateLocation(location);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteLocation()
	{
		locationService.deleteLocation(id);
	}
}
