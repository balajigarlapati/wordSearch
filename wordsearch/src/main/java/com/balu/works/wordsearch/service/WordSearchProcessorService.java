package com.balu.works.wordsearch.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.balu.works.wordsearch.domain.WordSearchDetails;
import com.balu.works.wordsearch.patterns.AbstractFileFactoryWordSearchProcessor;
import com.balu.works.wordsearch.patterns.WordSearchProcessor;

@Service
public class WordSearchProcessorService {

	public List<WordSearchDetails> getWordSerchDeatils(String fileName, String[] wordsToSearch){
		
		List<WordSearchDetails> summary = Collections.EMPTY_LIST;
		try {
			AbstractFileFactoryWordSearchProcessor processor = WordSearchProcessor.createWordSearchProcessor(fileName);
			summary = processor.getWordSerchDeatils(fileName, wordsToSearch);
			System.out.println("summary = "+summary);
		}catch(Exception ex) {
			System.out.println("In the WordSearchProcessorService got exception while getting words search summary "+ex.toString());
		}
		
		return summary;
	}
}
