package com.bean;

public class HangmanData {
	private int HID;
	private String word;
	public HangmanData()
	{
		
	}
	public HangmanData(int HID, String word)
	{
		this.HID = HID;
		this.word = word;
	}
	public int getHID() {
		return HID;
	}
	public void setHID(int hID) {
		HID = hID;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
}
