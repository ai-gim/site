/**
 * @File: CabinetListResource.java 
 * @Package  com.asiainfo.gim.site.api.resources
 * @Description: 
 * @author luyang
 * @date 2015年8月14日 下午4:24:47 
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
import com.asiainfo.gim.site.domain.Cabinet;
import com.asiainfo.gim.site.domain.query.CabinetQueryCondition;
import com.asiainfo.gim.site.service.CabinetService;

/**
 * @author luyang
 *
 */
@Path("/cabinets")
@Produces(MediaType.APPLICATION_JSON)
public class CabinetListResource
{
	private CabinetService cabinetService;
	
	@QueryParam("locationId")
	private Integer locationId;
	
	public CabinetListResource()
	{
		cabinetService = SpringContext.getBean(CabinetService.class);
	}
	
	@GET
	public List<Cabinet> getCabinet()
	{
		CabinetQueryCondition cabinetQueryCondition = new CabinetQueryCondition();
		cabinetQueryCondition.setLocationId(locationId);
		
		List<Cabinet> cabinets = cabinetService.listCabinets(cabinetQueryCondition);
		return cabinets;
	}
}
