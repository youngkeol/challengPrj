package com.challenge.entity;

public class Member {
	private int memNum;
	private String memId;
	private String memPw;
	private Boolean memGen;
	private String memEmail;
	
	public Member() {
		
	}

	public Member(int memNum, String memId, String memPw, Boolean memGen, String memEmail) {
		this.memNum = memNum;
		this.memId = memId;
		this.memPw = memPw;
		this.memGen = memGen;
		this.memEmail = memEmail;
	}




	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public Boolean getMemGen() {
		return memGen;
	}
	public void setMemGen(Boolean memGen) {
		this.memGen = memGen;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	
	
}
