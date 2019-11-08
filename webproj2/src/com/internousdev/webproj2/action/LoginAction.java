package com.internousdev.webproj2.action;

import com.internousdev.webproj2.dao.LoginDAO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport {

	private String username;
	private String password;

	public String execute() {

		String ret=ERROR;
		LoginDAO dao=new LoginDAO();
		boolean b=dao.select(username, password);
		if(b==true){
			ret=SUCCESS;
		}else{
			ret=ERROR;
		}
		return ret;

	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;

	}

	public String getPassword() {
		return password;

	}

	public void setPassword(String password) {
		this.password = password;

	}

}
