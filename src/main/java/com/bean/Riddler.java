package com.bean;

public class Riddler {
	private int User_UID;
	private int TScore;
	private int RiddlerData_RID;
	public Riddler() {
		
	}
	public Riddler(int user_UID, int tScore, int riddlerData_RID) {
		User_UID = user_UID;
		TScore = tScore;
		RiddlerData_RID = riddlerData_RID;
	}
	public int getUser_UID() {
		return User_UID;
	}
	public void setUser_UID(int user_UID) {
		User_UID = user_UID;
	}
	public int getTScore() {
		return TScore;
	}
	public void setTScore(int tScore) {
		TScore = tScore;
	}
	public int getRiddlerData_RID() {
		return RiddlerData_RID;
	}
	public void setRiddlerData_RID(int riddlerData_RID) {
		RiddlerData_RID = riddlerData_RID;
	}
	
}
