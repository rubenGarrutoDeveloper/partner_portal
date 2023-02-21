package com.partnerportal.springboot.utility;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constants
{
	//TODO sostituire mappa con gestore anagrafiche DB
	private static final Map<Integer, String> stateProjectMap;

	public static final String ddMMyyyyHHmmDatePattern = "dd-MM-yyyy HH:mm";

	static
	{
		Map<Integer, String> tempMap = new HashMap<>();
		tempMap.put(1, "started");
		tempMap.put(2, "work in progress");
		tempMap.put(3, "finished");
		stateProjectMap = Collections.unmodifiableMap(tempMap);
	}

	public static Map<Integer, String> getStateProjectMap()
	{
		return stateProjectMap;
	}

}
