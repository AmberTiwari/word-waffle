package com.bean;

public class RiddlerQueAns {

	private String rQue;
	private String rAns;
	
	public RiddlerQueAns() {
	}

	public RiddlerQueAns(String rQue, String rAns) 
	{
		this.rQue = rQue;
		this.rAns = rAns;
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
