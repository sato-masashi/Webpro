package com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dao.TestDAO;
import com.internousdev.webproj4.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{

	private String username;
	private String password;
	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	//executeメソッド
	public String execute() {
		String ret = "ERROR";
		TestDAO dao = new TestDAO();
		int count = dao.insert(username, password);

		//count変数が0より大きい場合
		if(count > 0) {
			ret = SUCCESS;
		} else {
			ret = ERROR;
		}
		//loginDTOList = selectメソッド
		loginDTOList = dao.select(username, password);

		return ret;
	}
//getter - username
	public String getUsername() {
		return username;
	}

//setter - username
	public void setUsername(String username) {
		//このクラスでの username
		this.username = username;
	}
//getter - password
	public String getPassword() {
		return password;
	}
//setter - password
	public void setPassword(String password) {
		this.password = password;
	}
//getter - loginDTOList
	public List<LoginDTO> getLoginDTOList() {
		return loginDTOList;
	}
//setter - loginDTOList
	public void setLoginDTOList(List<LoginDTO> loginDTOList) {
		this.loginDTOList = loginDTOList;
	}


}
