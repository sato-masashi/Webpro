package com.internousdev.webproj5.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webproj5.dao.LoginDAO;
import com.internousdev.webproj5.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	//jspから値を受け取るときの器
	private String username;
	private String password;

	//loginDTOListという箱を用意
	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();
	private Map<String, Object> session;

	public String execute() {
		//retの初期値="ERROR"
		String ret = ERROR;

		System.out.println(username);
		System.out.println(password);

		//dao という箱を用意：LoginDAO型
		LoginDAO dao = new LoginDAO(); //Q

		//daoのusername と passwordを選択して結果を格納
		loginDTOList = dao.select(username, password);

		//条件①・②を満たすとき
		 //条件①：this.username(このクラスの値) = loginDTOListから取得した値
		 //条件②：this.password(このクラスの値) = loginDTOListから取得した値
		if(this.username.equals(loginDTOList.get(0).getUsername())
		&& this.password.equals(loginDTOList.get(0).getPassword())){

			session.put("loginDTOList", loginDTOList); //Q
			ret = SUCCESS;
		}else {
			session.put("loginDTOList", loginDTOList);
			ret = ERROR;
		}

		return ret; //条件に合致→ifを抜け、retを返す=SUCCESSが返ってくる

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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
