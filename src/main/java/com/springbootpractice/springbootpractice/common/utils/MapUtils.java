package com.springbootpractice.springbootpractice.common.utils;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MapUtils {

    public static String paramMapToString(Map<String, String[]> paramMap) {
		return paramMap.entrySet().stream()
				.map(entry -> String.format("%s -> (%s)",entry.getKey(), Arrays.toString(entry.getValue())))
				.collect(Collectors.joining(", "));
	}
    
}
