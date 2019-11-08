package com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dao.HelloStrutsDAO;
import com.internousdev.webproj4.dto.HelloStrutsDTO;
import com.opensymphony.xwork2.ActionSupport;


public class HelloStrutsAction extends ActionSupport {

	private List<HelloStrutsDTO> helloStrutsDTOList = new ArrayList<HelloStrutsDTO>();

	public String execute() {
		String ret = ERROR;
		HelloStrutsDAO dao = new HelloStrutsDAO();
		helloStrutsDTOList = dao.select();

		if(helloStrutsDTOList.size() > 0) {
			ret = SUCCESS;
		}else{
			ret = ERROR;
		}
		return ret;
	}
	public List<HelloStrutsDTO> getHelloStrutsDTOList() {
		return helloStrutsDTOList;
	}

	public void setHelloStrutsDTOList(List<HelloStrutsDTO> helloStrutsDTOList) {
		this.helloStrutsDTOList = helloStrutsDTOList;
	}

}
