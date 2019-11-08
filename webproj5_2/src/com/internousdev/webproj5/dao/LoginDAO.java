package com.internousdev.webproj5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj5.dto.LoginDTO;
import com.internousdev.webproj5.util.DBConnector;

public class LoginDAO {

	public String username;
	public String password;


	public List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	//LoginDTO型を最後に呼出し元に渡すため、
		//LoginDTO型を戻り値にしたメソッドをつくる
	    //Actionクラスの値を引数として受け取る
	public List<LoginDTO> select(String username, String password) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from users where user_name=? and password=?";
		try {

			//定義したSQL文の
				//1番目の？ = Actionから送られたname
				//2番目の？ = Actionから送られたpassword がそれぞれ入る
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			//SQL文の実行メソッド、戻り値はResultSet
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				//SQL文でDBから取得した情報を
				//String型に変換してDTOクラスに格納
				//LoginDTOクラスのsetterを利用する
				LoginDTO dto = new LoginDTO();
				dto.setUsername(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
				loginDTOList.add(dto);
			}

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
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginDTOList;
	}

}
