package com.bean;

public class RiddlerData {
	private int RID;
	private String rQue;
	private String rAns;
	public RiddlerData()
	{
		
	}
	public RiddlerData(int rID, String rQue, String rAns) 
	{
		this.RID = rID;
		this.rQue = rQue;
		this.rAns = rAns;
	}
	public int getRID() {
		return RID;
	}
	public void setRID(int rID) {
		RID = rID;
	}
	public String getrQue() {
		return rQue;
	}
	public void setrQue(String rQue) {
		this.rQue = rQue;
	}
	public String getrAns() {
		return rAns;
	}
	public void setrAns(String rAns) {
		this.rAns = rAns;
	}
	
}
