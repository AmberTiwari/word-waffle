package com.bean;

public class UserHistory {
	private int U_ID;
	private int T_Score;
	private String time;
	private String gameName;
	public UserHistory() {
	}
	public UserHistory(int u_ID, int t_Score, String time, String gameName) {
		U_ID = u_ID;
		T_Score = t_Score;
		this.time = time;
		this.gameName = gameName;
	}
	public int getU_ID() {
		return U_ID;
	}
	public void setU_ID(int u_ID) {
		U_ID = u_ID;
	}
	public int getT_Score() {
		return T_Score;
	}
	public void setT_Score(int t_Score) {
		T_Score = t_Score;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
}
