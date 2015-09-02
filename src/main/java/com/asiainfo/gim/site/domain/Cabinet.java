/**
 * @File: Cabinet.java 
 * @Package  com.asiainfo.gim.site.domain
 * @Description: 
 * @author luyang
 * @date 2015年8月14日 下午3:54:35 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.site.domain;

import java.util.Map;

/**
 * @author luyang
 *
 */
public class Cabinet
{
	private Integer id;
	private Integer locationId;
	private String name;
	private Integer size;
	private Map<String, String> properties;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getLocationId()
	{
		return locationId;
	}

	public void setLocationId(Integer locationId)
	{
		this.locationId = locationId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getSize()
	{
		return size;
	}

	public void setSize(Integer size)
	{
		this.size = size;
	}

	public Map<String, String> getProperties()
	{
		return properties;
	}

	public void setProperties(Map<String, String> properties)
	{
		this.properties = properties;
	}

}
