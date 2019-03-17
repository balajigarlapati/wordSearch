package com.balu.works.wordsearch.utils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class FileUtils {

	public static Map<Integer, String> getIndexedLines(List<String> lines){
		final Map<Integer, String> map = new ConcurrentHashMap();
		IntStream.rangeClosed(0, lines.size()-1).parallel().forEach(f -> map.put(f+1,lines.get(f)));
		return map;
	}
}
