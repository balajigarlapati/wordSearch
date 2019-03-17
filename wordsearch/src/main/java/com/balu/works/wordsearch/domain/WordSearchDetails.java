package com.balu.works.wordsearch.domain;

import java.util.Set;

public class WordSearchDetails {

	String word;
	Set<Integer> lines;
	Long wordCount;
	
	public WordSearchDetails(){}
	
	public WordSearchDetails(String word, Set<Integer> lines, Long wordCount) {
		super();
		this.word = word;
		this.lines = lines;
		this.wordCount = wordCount;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Set<Integer> getLines() {
		return lines;
	}
	public void setLines(Set<Integer> set) {
		this.lines = set;
	}
	public Long getWordCount() {
		return wordCount;
	}
	public void setWordCount(Long wordCount) {
		this.wordCount = wordCount;
	}
	@Override
	public String toString() {
		return "WordSearchDetails [word=" + word + ", lines=" + lines + ", wordCount=" + wordCount + "]";
	}
}
