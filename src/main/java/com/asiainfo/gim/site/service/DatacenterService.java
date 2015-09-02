/**
 * @File: DatacenterService.java 
 * @Package  com.asiainfo.gim.site.service
 * @Description: 
 * @author luyang
 * @date 2015年8月12日 下午3:10:52 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.site.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asiainfo.gim.site.dao.DatacenterDao;
import com.asiainfo.gim.site.domain.Datacenter;

/**
 * @author luyang
 *
 */
@Service
public class DatacenterService
{
	private DatacenterDao datacenterDao;

	@Resource
	public void setDatacenterDao(DatacenterDao datacenterDao)
	{
		this.datacenterDao = datacenterDao;
	}
	
	public List<Datacenter> listDatacenters()
	{
		return datacenterDao.listDatacenters();
	}
	
	public Datacenter findDatacenterById(Integer id)
	{
		return datacenterDao.findDatacenterById(id);
	}
	
	public Datacenter findDatacenterByName(String name)
	{
		return datacenterDao.findDatacenterByName(name);
	}
	
	public Datacenter addDatacenter(Datacenter datacenter)
	{
		datacenterDao.insertDatacenter(datacenter);
		
		return findDatacenterById(datacenter.getId());
	}
	
	public Datacenter updateDatacenter(Datacenter datacenter)
	{
		datacenterDao.updateDatacenter(datacenter);
		
		return findDatacenterById(datacenter.getId());
	}
	
	public void deleteDatacenter(Integer id)
	{
		datacenterDao.deleteDatacenter(id);
	}
}
