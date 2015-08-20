/**
 * @File: CabinetQueryCondition.java 
 * @Package  com.asiainfo.gim.site.domain.query
 * @Description: 
 * @author luyang
 * @date 2015年8月14日 下午3:58:19 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.site.domain.query;

/**
 * @author luyang
 *
 */
public class CabinetQueryCondition extends QueryCondition
{
	private String locationId;

	public String getLocationId()
	{
		return locationId;
	}

	public void setLocationId(String locationId)
	{
		this.locationId = locationId;
	}
}
