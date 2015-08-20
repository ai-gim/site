/**
 * @File: LocationListResource.java 
 * @Package  com.asiainfo.gim.site.api.resources
 * @Description: 
 * @author luyang
 * @date 2015年8月14日 上午11:14:45 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.site.api.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.site.domain.Location;
import com.asiainfo.gim.site.domain.query.LocationQueryCondition;
import com.asiainfo.gim.site.service.LocationService;

/**
 * @author luyang
 *
 */
@Path("/locations")
@Produces(MediaType.APPLICATION_JSON)
public class LocationListResource
{
	private LocationService locationService;
	
	@QueryParam("datacenterId")
	private String datacenterId;
	
	public LocationListResource()
	{
		locationService = SpringContext.getBean(LocationService.class);
	}
	
	@GET
	public List<Location> getLocation()
	{
		LocationQueryCondition locationQueryCondition = new LocationQueryCondition();
		locationQueryCondition.setDatacenterId(datacenterId);
		
		List<Location> locations = locationService.listLocations(locationQueryCondition);
		return locations;
	}
}
