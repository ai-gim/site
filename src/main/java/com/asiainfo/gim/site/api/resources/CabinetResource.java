/**
 * @File: CabinetResource.java 
 * @Package  com.asiainfo.gim.site.api.resources
 * @Description: 
 * @author luyang
 * @date 2015年8月17日 上午9:24:24 
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
import com.asiainfo.gim.site.api.validator.CabinetValidator;
import com.asiainfo.gim.site.domain.Cabinet;
import com.asiainfo.gim.site.service.CabinetService;

/**
 * @author luyang
 *
 */
@Path("/cabinet")
@Produces(MediaType.APPLICATION_JSON)
public class CabinetResource
{
	private CabinetService cabinetService;
	
	@PathParam("id")
	private Integer id;
	
	public CabinetResource()
	{
		cabinetService = SpringContext.getBean(CabinetService.class);
	}
	
	@GET
	@Path("{id}")
	public Cabinet getCabinet()
	{
		Cabinet cabinet = cabinetService.findCabinetById(id);
		if (cabinet == null)
		{
			throw new ResourceNotFoundException();
		}
		return cabinet;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Cabinet addCabinet(@CabinetValidator Cabinet cabinet)
	{
		if (cabinet == null)
		{
			throw new ValidationException();
		}
		
		Cabinet cabinetInDb = cabinetService.findCabinetByName(cabinet.getName());
		if (cabinetInDb != null)
		{
			throw new ValidationException("Name conflict");
		}
		
		if (cabinet.getId() != null)
		{
			Cabinet cabinetInDbById = cabinetService.findCabinetById(cabinet.getId());
			if (cabinetInDbById != null)
			{
				throw new ValidationException("Id conflict");
			}
		}
		
		return cabinetService.addCabinet(cabinet);
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cabinet updateCabinet(@CabinetValidator Cabinet cabinet)
	{
		if (cabinet == null)
		{
			throw new ValidationException();
		}
		
		Cabinet cabinetInDb = cabinetService.findCabinetById(id);
		if (cabinetInDb == null)
		{
			throw new ResourceNotFoundException();
		}
		
		if (!StringUtils.equals(cabinet.getName(), cabinetInDb.getName()))
		{
			Cabinet cabinetInDbByName = cabinetService.findCabinetByName(cabinet.getName());
			if (cabinetInDbByName != null)
			{
				throw new ValidationException("Name conflict");
			}
		}
		
		cabinet.setId(id);
		
		return cabinetService.updateCabinet(cabinet);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteCabinet()
	{
		cabinetService.deleteCabinet(id);
	}
}
