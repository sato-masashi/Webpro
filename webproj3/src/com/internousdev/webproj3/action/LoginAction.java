package com.internousdev.webproj3.action;

import com.internousdev.webproj3.dao.LoginDAO;
import com.internousdev.webproj3.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction  extends ActionSupport {

	private String username;
	private String password;

	public String execute() {

		String ret=ERROR;

		System.out.println(username);
		System.out.println(password);
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();
		dto = dao.select(username, password);

		if(this.username.equals(dto.getUsername()) && this.password.equals(dto.getPassword())) {

			ret = SUCCESS;

		} else{

			ret = ERROR;

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
