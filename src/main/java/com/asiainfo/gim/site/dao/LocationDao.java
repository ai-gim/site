/**
 * @File: LocationDao.java 
 * @Package  com.asiainfo.gim.site.dao
 * @Description: 
 * @author luyang
 * @date 2015年8月14日 上午10:11:22 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.site.dao;

import java.util.List;

import com.asiainfo.gim.site.domain.Location;
import com.asiainfo.gim.site.domain.query.LocationQueryCondition;

/**
 * @author luyang
 *
 */
public interface LocationDao
{
	public List<Location> listLocations(LocationQueryCondition locationQueryCondition);
	
	public Location findLocationById(String id);
	
	public Location findLocationByName(String name);
	
	public void insertLocation(Location location);
	
	public void updateLocation(Location location);
	
	public void deleteLocation(String id);
}
