package com.internousdev.webproj5.dto;

public class LoginDTO {

	//TBから取得するデータに対応したフィールド変数の宣言
	private String username;
	private String password;

	//Actionに渡す
	public String getUsername() {
		return username;
	}
	//DAOからテーブルのデータを受け取って格納
	public void setUsername(String username) {
		this.username = username;
	}
	//Actionに渡す
	public String getPassword() {
		return password;
	}
	//DAOからテーブルのデータを受け取って格納
	public void setPassword(String password) {
		this.password = password;
	}
}

//getter:Actionクラスから呼出され、nameフィールドの値をActionに渡す
//setter:DAOクラスから呼出される。受け取ったテーブルの値を自身のnameフィールドに格納
 //自身のフィールド変数 = 受け取ったテーブルの値
