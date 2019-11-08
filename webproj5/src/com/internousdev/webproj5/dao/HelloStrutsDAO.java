package com.internousdev.webproj5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj5.dto.HelloStrutsDTO;
import com.internousdev.webproj5.util.DBConnector;


public class HelloStrutsDAO {

	//helloStrutsDTOList インスタンス化
	List<HelloStrutsDTO> helloStrutsDTOList = new ArrayList<HelloStrutsDTO>();

	//selectメソッド
	public List<HelloStrutsDTO> select() {
		DBConnector db = new DBConnector();
		//DBとの必要な情報：接続url,接続user名,接続PWをgetConnectionメソッドで取得
		Connection con = db.getConnection();

//usersテーブルを選択
		String sql = "select * from users";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
//SQL文を実行
			ResultSet rs = ps.executeQuery();

//rsの値が続く間
			while(rs.next()) {
				HelloStrutsDTO dto = new HelloStrutsDTO();
				dto.setUserId(rs.getInt("user_id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
				dto.setResult("MySQLと接続できます。");
				helloStrutsDTOList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();//DBとの接続解除
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return helloStrutsDTOList;
	}


}
