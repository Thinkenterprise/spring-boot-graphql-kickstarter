package com.thinkenterprise.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyUtils {
	
	static Map<Long, List<Long>> keys = new HashMap<Long, List<Long>>();
	
	static {
		keys.put(101L, Arrays.asList(1L));
		keys.put(102L, Arrays.asList(2L) );
		keys.put(103L, Arrays.asList(3L) );
    }

	public static List<Long> getKeys(Long route) {
		return keys.get(route);
	}

}
