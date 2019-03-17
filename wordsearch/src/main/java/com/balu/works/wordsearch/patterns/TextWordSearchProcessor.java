package com.balu.works.wordsearch.patterns;

import com.balu.works.wordsearch.parser.FileParser;
import com.balu.works.wordsearch.parser.TextFileParser;

public class TextWordSearchProcessor extends AbstractFileFactoryWordSearchProcessor {

	@Override
	public FileParser createParser() {
		return new TextFileParser();
	}

}
