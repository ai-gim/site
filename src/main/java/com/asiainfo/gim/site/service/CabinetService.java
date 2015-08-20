/**
 * @File: CabinetService.java 
 * @Package  com.asiainfo.gim.site.service
 * @Description: 
 * @author luyang
 * @date 2015年8月14日 下午4:11:09 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.site.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.asiainfo.gim.site.dao.CabinetDao;
import com.asiainfo.gim.site.domain.Cabinet;
import com.asiainfo.gim.site.domain.query.CabinetQueryCondition;

/**
 * @author luyang
 *
 */
@Service
public class CabinetService
{
	private CabinetDao cabinetDao;

	@Resource
	public void setCabinetDao(CabinetDao cabinetDao)
	{
		this.cabinetDao = cabinetDao;
	}
	
	public List<Cabinet> listCabinets(CabinetQueryCondition cabinetQueryCondition)
	{
		return cabinetDao.listCabinets(cabinetQueryCondition);
	}

	public Cabinet findCabinetById(String id)
	{
		return cabinetDao.findCabinetById(id);
	}

	public Cabinet findCabinetByName(String name)
	{
		return cabinetDao.findCabinetByName(name);
	}

	public Cabinet addCabinet(Cabinet cabinet)
	{
		if (StringUtils.isEmpty(cabinet.getId()))
		{
			cabinet.setId(UUID.randomUUID().toString());
		}
		
		cabinetDao.insertCabinet(cabinet);
		
		return findCabinetById(cabinet.getId());
	}

	public Cabinet updateCabinet(Cabinet cabinet)
	{
		cabinetDao.updateCabinet(cabinet);
		return findCabinetById(cabinet.getId());
	}

	public void deleteCabinet(String id)
	{
		cabinetDao.deleteCabinet(id);
	}
}
