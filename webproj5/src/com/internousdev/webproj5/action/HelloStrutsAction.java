package com.internousdev.webproj5.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webproj5.dao.HelloStrutsDAO;
import com.internousdev.webproj5.dto.HelloStrutsDTO;
import com.opensymphony.xwork2.ActionSupport;

//Sessionに関する記述
public class HelloStrutsAction extends ActionSupport implements SessionAware{
	//helloStrutsDTOList としてインスタンス化
	private List<HelloStrutsDTO> helloStrutsDTOList = new ArrayList<HelloStrutsDTO>();
	private Map<String, Object> session;

	//実行メソッド
	public String execute() {
		String ret = ERROR;
		HelloStrutsDAO dao = new HelloStrutsDAO(); //HelloStrutsDAOをインスタンス化
		helloStrutsDTOList = dao.select();

		if(helloStrutsDTOList.size() > 0) {
			session.put("helloStrutsDTOList", helloStrutsDTOList);
			ret = SUCCESS;
		} else {
			ret = ERROR;
		}
		return ret;
	}

	//getter - getSession
	public Map<String, Object> getSession() {
		return session;
	}
	//setter - setSession
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
