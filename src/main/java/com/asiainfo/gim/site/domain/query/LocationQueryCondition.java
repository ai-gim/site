/**
 * @File: LocationQueryCondition.java 
 * @Package  com.asiainfo.gim.server.domain.query
 * @Description: 
 * @author luyang
 * @date 2015年8月7日 上午9:13:11 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.site.domain.query;

/**
 * @author luyang
 *
 */
public class LocationQueryCondition extends QueryCondition
{
	private String datacenterId;

	public String getDatacenterId()
	{
		return datacenterId;
	}

	public void setDatacenterId(String datacenterId)
	{
		this.datacenterId = datacenterId;
	}
}
