package com.internousdev.webproj4.dto;

public class InquiryDTO {

//変数制限 private
	private String name;
	private String qtype;
	private String body;

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

}
