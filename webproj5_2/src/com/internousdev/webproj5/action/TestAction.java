package com.internousdev.webproj5.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webproj5.dao.TestDAO;
import com.internousdev.webproj5.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport implements SessionAware{

	private  String username;
	private  String password;

	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	private Map<String, Object> session;


	public String execute() {
		String ret = ERROR;

		TestDAO dao = new TestDAO();
		int count = dao.insert(username, password);

		if(count > 0) {
			ret = SUCCESS;
		}else {
			ret = ERROR;
		}

		loginDTOList = dao.select(username, password);
		session.put("loginDTOList", loginDTOList);

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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
