package com.bean;

public class Jumbled {
	private int User_UID;
	private int TScore;
	private int JumbledData_JID;
	
	public Jumbled() {
	}

	public Jumbled(int user_UID, int tScore, int jumbledData_JID) {
		User_UID = user_UID;
		TScore = tScore;
		JumbledData_JID = jumbledData_JID;
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

	public int getJumbledData_JID() {
		return JumbledData_JID;
	}

	public void setJumbledData_JID(int jumbledData_JID) {
		JumbledData_JID = jumbledData_JID;
	}
	
}
