package com.bean;

public class Hangman 
{
	private int Hangman_UID;
	private int TScore;
	private int Hangman_HID;
	public Hangman()
	{
		
	}
	public Hangman(int Hangman_UID, int TScore, int HID)
	{
		this.Hangman_UID = Hangman_UID;
		this.TScore = TScore;
		this.Hangman_HID = HID;
	}
	public int getHangman_UID() {
		return Hangman_UID;
	}
	public void setHangman_UID(int uID) {
		Hangman_UID = uID;
	}
	public int getTScore() {
		return TScore;
	}
	public void setTScore(int tScore) {
		TScore = tScore;
	}
	public int getHangman_HID() {
		return Hangman_HID;
	}
	public void setHangman_HID(int hangman_HID) {
		Hangman_HID = hangman_HID;
	}
}
