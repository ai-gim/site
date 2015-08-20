/**
 * @File: Datacenter.java 
 * @Package  com.asiainfo.gim.site.domain
 * @Description: 
 * @author luyang
 * @date 2015年8月12日 下午2:20:52 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.site.domain;

import java.util.Map;

/**
 * @author luyang
 *
 */
public class Datacenter
{
	private String id;
	private String name;
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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
