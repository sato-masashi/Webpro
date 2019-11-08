package com.internousdev.webproj4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dto.LoginDTO;
import com.internousdev.webproj4.util.DBConnector;

//TestDAOクラス
public class TestDAO {

	//インスタンス化
	public List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	//int型 insertメソッド
	public int insert(String username,String password) {
		int ret = 0;
		DBConnector db = new DBConnector(); //インスタンス化
		Connection con = db.getConnection(); //DBとの接続

		//文字列型 sql : SQL文を格納
		String sql = "insert into users(user_name,password) values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			//SQL文の実行
			int i = ps.executeUpdate();
			if (i>0) {
				System.out.println(i + "件登録されました");
				ret = i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try{
			//DBとの接続を解除
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public List<LoginDTO> select(String username,String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//文字列型 sql : SQL文を格納:users の user_name と password を選択
		String sql = "select * from users where user_name=? and password=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			//SQL文実行メソッド
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				LoginDTO dto = new LoginDTO();
				dto.setUsername(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
				loginDTOList.add(dto);
			}
			//loginDTOListの要素数が0以下なら
			if(loginDTOList.size()<=0) {
				LoginDTO dto = new LoginDTO();
				dto.setUsername("該当なし");
				dto.setPassword("該当なし");
				loginDTOList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			//DBとの接続解除
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginDTOList;
	}



}
