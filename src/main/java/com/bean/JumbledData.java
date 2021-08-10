package com.bean;

public class JumbledData 
{
	private int JID;
	private String jQue;
	private String jAns;
	public JumbledData() {
	
	}
	public JumbledData(int jID, String jQue, String jAns) {
		this.JID = jID;
		this.jQue = jQue;
		this.jAns = jAns;
	}
	public int getJID() {
		return JID;
	}
	public void setJID(int jID) {
		JID = jID;
	}
	public String getjQue() {
		return jQue;
	}
	public void setjQue(String jQue) {
		this.jQue = jQue;
	}
	public String getjAns() {
		return jAns;
	}
	public void setjAns(String jAns) {
		this.jAns = jAns;
	}	
}
