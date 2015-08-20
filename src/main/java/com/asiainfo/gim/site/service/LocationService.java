/**
 * @File: LocationService.java 
 * @Package  com.asiainfo.gim.site.service
 * @Description: 
 * @author luyang
 * @date 2015年8月14日 上午11:05:34 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.site.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.asiainfo.gim.site.dao.LocationDao;
import com.asiainfo.gim.site.domain.Location;
import com.asiainfo.gim.site.domain.query.LocationQueryCondition;

/**
 * @author luyang
 *
 */
@Service
public class LocationService
{
	private LocationDao locationDao;

	@Resource
	public void setLocationDao(LocationDao locationDao)
	{
		this.locationDao = locationDao;
	}
	
	public List<Location> listLocations(LocationQueryCondition locationQueryCondition)
	{
		return locationDao.listLocations(locationQueryCondition);
	}
	
	public Location findLocationById(String id)
	{
		return locationDao.findLocationById(id);
	}

	public Location findLocationByName(String name)
	{
		return locationDao.findLocationByName(name);
	}
	
	public Location addLocation(Location location)
	{
		if (StringUtils.isEmpty(location.getId()))
		{
			location.setId(UUID.randomUUID().toString());
		}
		
		locationDao.insertLocation(location);
		
		return findLocationById(location.getId());
	}
	
	public Location updateLocation(Location location)
	{
		locationDao.updateLocation(location);
		
		return findLocationById(location.getId());
	}
	
	public void deleteLocation(String id)
	{
		locationDao.deleteLocation(id);
	}
}
