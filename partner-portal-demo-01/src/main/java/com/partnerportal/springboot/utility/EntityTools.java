package com.partnerportal.springboot.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.partnerportal.springboot.entity.RelProjectPhase;

public class EntityTools
{

	/**
	 * Extracts the idPhase values from a list of ViewRelProjectPhase objects
	 * and returns them as a list of integers.
	 *
	 * @param list the input list of ViewRelProjectPhase objects
	 * @return a list of integers representing the idPhase values
	 */
	public static List<Integer> extractIdPhases(List<RelProjectPhase> list)
	{
		if(Tools.isNullOrEmpty(list))
			return new ArrayList<>();

		// Use a lambda expression to map each RelProjectPhase object to its idPhase value
		List<Integer> idPhases = list.stream()
				.map(RelProjectPhase -> RelProjectPhase.getIdPhase())
				.collect(Collectors.toList());

		return idPhases;
	}

}
