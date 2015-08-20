/**
 * @File: DatacenterListResource.java 
 * @Package  com.asiainfo.gim.site.api.resources
 * @Description: 
 * @author luyang
 * @date 2015年8月12日 下午3:51:37 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.site.api.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.site.domain.Datacenter;
import com.asiainfo.gim.site.service.DatacenterService;

/**
 * @author luyang
 *
 */
@Path("/datacenters")
@Produces(MediaType.APPLICATION_JSON)
public class DatacenterListResource
{
	private DatacenterService datacenterService;
	
	public DatacenterListResource()
	{
		datacenterService = SpringContext.getBean(DatacenterService.class);
	}
	
	@GET
	public List<Datacenter> getDatacenters()
	{
		return datacenterService.listDatacenters();
	}
}
