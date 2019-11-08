package com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dao.LoginDAO;
import com.internousdev.webproj4.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction  extends ActionSupport {

	private String username;
	private String password;
	private List<LoginDTO> LoginDTOList = new ArrayList<LoginDTO>();

//executeメソッド：戻り値(文字列：username)
	public String execute() {
		String ret=ERROR;
		System.out.println(username);
		System.out.println(password);
		LoginDAO dao = new LoginDAO();

		LoginDTOList = dao.select(username,password);
		if(this.username.equals(LoginDTOList.get(0).getUsername()) &&
		this.password.equals(LoginDTOList.get(0).getPassword())){
			ret = SUCCESS;
		}else{
			ret = ERROR;
		}

		return ret;
	}
//取得制限 型名 getterの名称
	public String getUsername() {
		return username;
	}
//取得制限 void setterの名称
	public void setUsername(String username) {
		//this.username:変更した"username"のデータを格納
		this.username = username;
	}

	public String getPassword() {
		//"password"の値を取得して戻り値として返す
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<LoginDTO> getLoginDTOList() {
		return LoginDTOList;
	}

	public void setLoginDTO(List<LoginDTO> loginDTOList) {
		LoginDTOList = loginDTOList;
	}
}
