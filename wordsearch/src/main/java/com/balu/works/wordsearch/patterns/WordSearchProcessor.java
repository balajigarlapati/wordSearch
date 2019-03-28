package com.balu.works.wordsearch.patterns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WordSearchProcessor {
	
	WordSearchProcessor(){
		System.out.println("WordSearchProcessor is created");
	}

	@Autowired
	TextWordSearchProcessor textWordSearchProcessor;
	
	public AbstractFileFactoryWordSearchProcessor createWordSearchProcessor(String fileName){
		
		if(fileName.endsWith(".log") || fileName.endsWith(".txt") || fileName.endsWith(".doc")) {
			return textWordSearchProcessor;
		}
		
		return null;
	}
}
