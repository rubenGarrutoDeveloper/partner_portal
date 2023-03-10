package com.partnerportal.springboot.utility;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constants
{
	//TODO sostituire mappa con gestore anagrafiche DB
	private static final Map<Integer, String> stateProjectMap;

	// Anag Status
	public static int ID_STATUS_STARTED = 1;
	public static int ID_STATUS_WIP = 2;
	public static int ID_STATUS_FINISHED = 3;

	public static final String ddMMyyyyHHmmDatePattern = "dd-MM-yyyy HH:mm";

	static
	{
		Map<Integer, String> tempMap = new HashMap<>();
		tempMap.put(ID_STATUS_STARTED, "started");
		tempMap.put(ID_STATUS_WIP, "work in progress");
		tempMap.put(ID_STATUS_FINISHED, "finished");
		stateProjectMap = Collections.unmodifiableMap(tempMap);
	}

	public static Map<Integer, String> getStateProjectMap()
	{
		return stateProjectMap;
	}

}
