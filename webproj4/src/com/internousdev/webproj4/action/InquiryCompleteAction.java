package com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dao.InquiryCompleteDAO;
import com.internousdev.webproj4.dto.InquiryDTO;
import com.opensymphony.xwork2.ActionSupport;

//InquiryCompleteActionクラス
public class InquiryCompleteAction extends ActionSupport{

	private String name;
	private String qtype;
	private String body;

	private List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();

	//executeメソッド
	public String execute() {
		String ret = ERROR;
		InquiryCompleteDAO dao = new InquiryCompleteDAO();
//count:int型 - dao.insertメソッドをカウント
		int count = dao.insert(name, qtype, body);
		if(count > 0){
//dao.selectメソッドをinquiryDTOListへ格納
			inquiryDTOList=dao.select();

			ret = SUCCESS;
		}
		return ret;
	}
//getter - name
	public String getName() {
		return name;
	}
//setter - name
	public void setName(String name) {
		this.name = name;
	}
//getter - qtype
	public String getQtype() {
		return qtype;
	}
//setter - qtype
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
//getter - body
	public String getBody() {
		return body;
	}
//setter - body
	public void setBody(String body) {
		this.body = body;
	}
//getter - inquiryDTOList
	public List<InquiryDTO> getInquiryDTOList() {
		return inquiryDTOList;
	}
//setter - inquiryDTOList
	public void setInquiryDTOList(List<InquiryDTO> inquiryDTOList) {
		this.inquiryDTOList = inquiryDTOList;
	}
}
