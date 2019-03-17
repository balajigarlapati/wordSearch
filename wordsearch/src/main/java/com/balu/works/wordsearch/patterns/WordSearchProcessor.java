package com.balu.works.wordsearch.patterns;

import com.balu.works.wordsearch.patterns.AbstractFileFactoryWordSearchProcessor;
import com.balu.works.wordsearch.patterns.TextWordSearchProcessor;

public class WordSearchProcessor {

	public static AbstractFileFactoryWordSearchProcessor createWordSearchProcessor(String fileName){
		
		if(fileName.endsWith(".log") || fileName.endsWith(".txt") || fileName.endsWith(".doc")) {
			return new TextWordSearchProcessor();
		}
		
		return null;
	}
}
