/**
 * @File: DatacenterDao.java 
 * @Package  com.asiainfo.gim.site.dao
 * @Description: 
 * @author luyang
 * @date 2015年8月12日 下午2:40:58 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.site.dao;

import java.util.List;

import com.asiainfo.gim.site.domain.Datacenter;

/**
 * @author luyang
 *
 */
public interface DatacenterDao
{
	public List<Datacenter> listDatacenters();
	
	public Datacenter findDatacenterById(String id);
	
	public Datacenter findDatacenterByName(String name);
	
	public void insertDatacenter(Datacenter datacenter);
	
	public void updateDatacenter(Datacenter datacenter);
	
	public void deleteDatacenter(String id);
}
