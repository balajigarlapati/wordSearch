package com.balu.works.wordsearch.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.balu.works.wordsearch.domain.WordSearchDetails;

public class WordSearchCalculator {
	
	public static List<WordSearchDetails> getWordStatistics(List<String> lines,String[] wordsToSearch){
		
		if( (lines == null || lines.isEmpty()) || checkIfInputIsNull(wordsToSearch)) {
			return Collections.EMPTY_LIST;
		}
		
		List<WordSearchDetails> output  = new ArrayList();
		
		for(int i=0; i< wordsToSearch.length;i++) {
			WordSearchDetails wordSearchDetails = new WordSearchDetails();
			String word = wordsToSearch[i];
			wordSearchDetails.setWord(word);
			wordSearchDetails.setWordCount(0L);
			
			try {
				Map<Integer, String> map = FileUtils.getIndexedLines(lines);
				Map<Integer, String> reqdMap = wordPresentInLinesMap(map, word);
				
				if(!reqdMap.isEmpty()) {
					Long wordCount = reqdMap.values().parallelStream().flatMap(Pattern.compile(" ")::splitAsStream).filter(str -> str.equalsIgnoreCase(word)).collect(Collectors.counting());
					wordSearchDetails.setWordCount(wordCount);
					wordSearchDetails.setLines(reqdMap.keySet());
				}
			}catch(Exception ex){
				System.out.println("Got error while getting the WordSearchDetails for "+word+" "+ex.toString());
			}
			
			output.add(wordSearchDetails);
		}
			
		return output;	
	}
	
	static Map<Integer, String> wordPresentInLinesMap(Map<Integer, String> map,String word){
		Pattern wordPattern = Pattern.compile("\\b"+word+"\\b");
		
		final Map<Integer, String> reqdMap = new ConcurrentHashMap<>();
		map.entrySet().parallelStream().filter(entry -> wordPattern.matcher(entry.getValue()).find())
					.forEach(f -> reqdMap.put(f.getKey(),f.getValue().trim()));
		
		return reqdMap;
	}
	
	static boolean checkIfInputIsNull(String[] input){
	
		return (input == null || (input != null && input.length == 0));
	}
}
