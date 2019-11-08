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
	public List<LoginDTO> select(String username,String password) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();//DB接続

		String sql = "select * from users where user_name=? and password=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();//SQL文実行
//DTOクラス
			while (rs.next()) {
				LoginDTO dto = new LoginDTO();//LoginDTOクラスインスタンス化
				dto.setUsername(rs.getString("user_name"));//←ミスってた（user_nameのアンダーバーが抜けてた）
				dto.setPassword(rs.getString("password"));
				loginDTOList.add(dto);
			}
//DTOクラス
			if(loginDTOList.size()<=0){
				LoginDTO dto = new LoginDTO();
				dto.setUsername("該当なし");
				dto.setPassword("該当なし");
				loginDTOList.add(dto);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();//DB接続解除
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginDTOList;//DAOが返すお土産
	}

}
