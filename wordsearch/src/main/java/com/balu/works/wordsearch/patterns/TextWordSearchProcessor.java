package com.balu.works.wordsearch.patterns;

import org.springframework.stereotype.Component;

import com.balu.works.wordsearch.parser.FileParser;
import com.balu.works.wordsearch.parser.TextFileParser;

@Component
public class TextWordSearchProcessor extends AbstractFileFactoryWordSearchProcessor {
	
	TextWordSearchProcessor(){
		System.out.println("Constructor is called");
	}

	@Override
	public FileParser createParser() {
		return new TextFileParser();
	}

}
