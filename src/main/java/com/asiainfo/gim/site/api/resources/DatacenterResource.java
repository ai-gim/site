/**
 * @File: DatacenterResource.java 
 * @Package  com.asiainfo.gim.site.api.resources
 * @Description: 
 * @author luyang
 * @date 2015年8月12日 下午4:28:07 
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
import com.asiainfo.gim.site.api.validator.DatacenterValidator;
import com.asiainfo.gim.site.domain.Datacenter;
import com.asiainfo.gim.site.service.DatacenterService;

/**
 * @author luyang
 *
 */
@Path("/datacenter")
@Produces(MediaType.APPLICATION_JSON)
public class DatacenterResource
{
	private DatacenterService datacenterService;
	
	@PathParam("id")
	private Integer id;
	
	public DatacenterResource()
	{
		datacenterService = SpringContext.getBean(DatacenterService.class);
	}
	
	@GET
	@Path("{id}")
	public Datacenter getDatacenter()
	{
		Datacenter datacenter = datacenterService.findDatacenterById(id);
		if (datacenter == null)
		{
			throw new ResourceNotFoundException();
		}
		return datacenter;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Datacenter addDatacenter(@DatacenterValidator Datacenter datacenter)
	{
		if (datacenter == null)
		{
			throw new ValidationException();
		}
		
		Datacenter datacenterInDb = datacenterService.findDatacenterByName(datacenter.getName());
		if (datacenterInDb != null)
		{
			throw new ValidationException("Name conflict");
		}
		
		if (datacenter.getId() != null)
		{
			Datacenter datacenterInDbById = datacenterService.findDatacenterById(datacenter.getId());
			if (datacenterInDbById != null)
			{
				throw new ValidationException("Id conflict");
			}
		}
		
		return datacenterService.addDatacenter(datacenter);
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Datacenter updateDatacenter(@DatacenterValidator Datacenter datacenter)
	{
		if (datacenter == null)
		{
			throw new ValidationException();
		}
		
		Datacenter datacenterInDb = datacenterService.findDatacenterById(id);
		if (datacenterInDb == null)
		{
			throw new ResourceNotFoundException();
		}
		
		if (!StringUtils.equals(datacenter.getName(), datacenterInDb.getName()))
		{
			Datacenter datacenterInDbByName = datacenterService.findDatacenterByName(datacenter.getName());
			if (datacenterInDbByName != null)
			{
				throw new ValidationException("Name conflict");
			}
		}
		
		datacenter.setId(id);
		
		return datacenterService.updateDatacenter(datacenter);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteDatacenter()
	{
		datacenterService.deleteDatacenter(id);
	}
}
