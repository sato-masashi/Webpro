package com.internousdev.webproj.action;

import com.opensymphony.xwork2.ActionSupport;

//Struts2が持つ『AcctionSupportクラス』を継承する
public class HelloStrutsAction extends ActionSupport{

	//実行メソッド（execute)
	public String execute() {

		return SUCCESS;

	}


}
