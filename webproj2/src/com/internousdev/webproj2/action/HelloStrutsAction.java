package com.internousdev.webproj2.action;

import com.internousdev.webproj2.dao.HelloStrutsDAO;
import com.opensymphony.xwork2.ActionSupport;




public class HelloStrutsAction extends ActionSupport {

	public String execute() {

		String ret = ERROR;


		HelloStrutsDAO dao=new HelloStrutsDAO();

		boolean b = dao.select();

		if(b==true) {

			ret=SUCCESS;

		}else{
			ret=ERROR;
		}

		return ret;



	}

}
