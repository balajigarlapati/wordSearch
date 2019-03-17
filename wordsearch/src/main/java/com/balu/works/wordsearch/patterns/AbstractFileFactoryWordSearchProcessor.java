package com.balu.works.wordsearch.patterns;

import java.io.File;
import java.util.Collections;
import java.util.List;

import com.balu.works.wordsearch.domain.WordSearchDetails;
import com.balu.works.wordsearch.parser.FileParser;
import com.balu.works.wordsearch.utils.WordSearchCalculator;

public abstract class AbstractFileFactoryWordSearchProcessor {

	public List<WordSearchDetails> getWordSerchDeatils(String fileName,String[] inputWords) {
		List<WordSearchDetails> summary = Collections.EMPTY_LIST;
		try {
			File file = openfile(fileName);
			FileParser parser = createParser();
			List<String> lines = parser.parseFile(file);
			System.out.println("Lines count "+lines.size());
			summary = WordSearchCalculator.getWordStatistics(lines, inputWords);
		}catch(Exception ex) {
			System.out.println("Got exception while searching words in input file "+ex.toString());
		}
		return summary;
	}

	private File openfile(String fileName) {
		System.out.println("Opened File");
		File file = null;
		try{
			file = new File(fileName);
			
			System.out.println(""+file.getName()+file.length());
		}catch(Exception ex) {
			System.out.println("Got Exception while opening file "+ex.toString());
			throw ex;
		}
		return file;
	}

	public abstract FileParser createParser();
	
}
