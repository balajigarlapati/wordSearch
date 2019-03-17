package com.balu.works.wordsearch.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TextFileParser implements FileParser{

	public TextFileParser(){}
	
	@Override
	public List<String> parseFile(File file) {
		List<String> lines = Collections.EMPTY_LIST;
		try (Scanner scanner = new Scanner(file)) {
			lines = new ArrayList();
		    while (scanner.hasNext()) {
		    	lines.add(scanner.nextLine());
		    }
		} catch (FileNotFoundException fnfe) {
		    fnfe.printStackTrace();
		}
		
		return lines;
	}

}
