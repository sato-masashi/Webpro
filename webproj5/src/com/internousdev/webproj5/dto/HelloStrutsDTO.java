package com.internousdev.webproj5.dto;


public class HelloStrutsDTO {
	private int userId;
	private String userName;
	private String password;
	private String result;

//getter - getUserId:int型
	public int getUserId() {
		return userId;
	}
//setter - setUserId:int型
	public void setUserId(int userId) {
		this.userId = userId;
	}
//getter - getUserName
	public String getUserName() {
		return userName;
	}
//setter - setUserName
	public void setUserName(String userName) {
		this.userName = userName;
	}
//getter - getPassword
	public String getPassword() {
		return password;
	}
//setter - setPassword
	public void setPassword(String password) {
		this.password = password;
	}
//getter - getResult
	public String getResult() {
		return result;
	}
//setter - setResult
	public void setResult(String result) {
		this.result = result;
	}
}
