package com.internousdev.webproj4.dto;

public class LoginDTO {

	//文字列型の変数を宣言：他クラスからの呼出・変更不可
	private String username;
	private String password;

	//【1:getterメソッド】
	 //他クラスから username を取得するためのメソッド
	  //だから"public" + 型 + getフィールド名メソッド
	public String getUsername() {
		return username;
	}

	//【1:setterメソッド】
	 //他クラスから username を書き換えるためのメソッド
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
