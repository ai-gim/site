/**
 * @File: Location.java 
 * @Package  com.asiainfo.gim.site.domain
 * @Description: 
 * @author luyang
 * @date 2015年8月14日 上午9:58:58 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.site.domain;

import java.util.Map;

/**
 * @author luyang
 *
 */
public class Location
{
	private String id;
	private String datacenterId;
	private String name;
	private String site;
	private String floor;
	private String room;
	private String description;
	private Map<String, String> properties;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getDatacenterId()
	{
		return datacenterId;
	}

	public void setDatacenterId(String datacenterId)
	{
		this.datacenterId = datacenterId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSite()
	{
		return site;
	}

	public void setSite(String site)
	{
		this.site = site;
	}

	public String getFloor()
	{
		return floor;
	}

	public void setFloor(String floor)
	{
		this.floor = floor;
	}

	public String getRoom()
	{
		return room;
	}

	public void setRoom(String room)
	{
		this.room = room;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
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
