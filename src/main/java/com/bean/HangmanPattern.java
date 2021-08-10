package com.bean;

public class HangmanPattern {
	private String word;
	private String asterisk;
	public HangmanPattern(String word, String asterisk)
	{
		this.word = word;
		this.asterisk = asterisk;
	}
	public HangmanPattern() 
	{
	
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getAsterisk() {
		return asterisk;
	}
	public void setAsterisk(String asterisk) {
		this.asterisk = asterisk;
	}	
}
