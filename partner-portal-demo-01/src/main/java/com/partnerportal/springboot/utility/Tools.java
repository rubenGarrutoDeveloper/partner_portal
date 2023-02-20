package com.partnerportal.springboot.utility;

import java.util.Collection;
import java.util.Map;

public class Tools
{
	public static boolean isNullOrEmpty(String str)
	{
		return str == null || str.isEmpty();
	}

	public static boolean isNullOrEmpty(Collection<?> collection)
	{
		return collection == null || collection.isEmpty();
	}

	public static boolean isNullOrEmpty(Map<?, ?> map)
	{
		return map == null || map.isEmpty();
	}

}
