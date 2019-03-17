package com.balu.works.wordsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.balu.works.wordsearch.domain.WordSearchDetails;
import com.balu.works.wordsearch.service.WordSearchProcessorService;

@RestController
@RequestMapping("/")
public class WordSearchStatisticsController {
	@Autowired
	WordSearchProcessorService wordSearchProcessorService ;
	
	@GetMapping("wordsearch")
	public ResponseEntity<List<WordSearchDetails>> getWordSearchDetails(@RequestParam(value="fileName") String fileName,@RequestParam(value="wordsToSearch") String[] wordsToSearch){
		List<WordSearchDetails> summary = wordSearchProcessorService.getWordSerchDeatils(fileName, wordsToSearch);
		return new ResponseEntity<List<WordSearchDetails>>(summary,HttpStatus.OK);
	}

}
