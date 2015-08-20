/**
 * @File: CabinetDao.java 
 * @Package  com.asiainfo.gim.site.dao
 * @Description: 
 * @author luyang
 * @date 2015年8月14日 下午3:57:40 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.site.dao;

import java.util.List;

import com.asiainfo.gim.site.domain.Cabinet;
import com.asiainfo.gim.site.domain.query.CabinetQueryCondition;

/**
 * @author luyang
 *
 */
public interface CabinetDao
{
	public List<Cabinet> listCabinets(CabinetQueryCondition cabinetQueryCondition);

	public Cabinet findCabinetById(String id);

	public Cabinet findCabinetByName(String name);

	public void insertCabinet(Cabinet cabinet);

	public void updateCabinet(Cabinet cabinet);

	public void deleteCabinet(String id);
}
