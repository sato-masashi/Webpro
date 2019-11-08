package com.internousdev.webproj4.dao;

//外部クラスからのインポート
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dto.InquiryDTO;
import com.internousdev.webproj4.util.DBConnector;

//クラスメソッド：InquiryCompleteDAO
public class InquiryCompleteDAO {

//inquiryDTOListのインスタンス化
	List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();

//selectメソッド
	public List<InquiryDTO> select(){
		//DBConnectorのインスタンス化：dbに格納
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();


		String sql = "select * from inquiry";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				//InquiryDTOのインスタンス化：dtoに格納
				InquiryDTO dto = new InquiryDTO();
				dto.setName(rs.getString("name"));
				dto.setQtype(rs.getString("qtype"));
				dto.setBody(rs.getString("body"));
				inquiryDTOList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//inquiryDTOを返す
		return inquiryDTOList;
	}

//insertメソッド：int型
	public int insert(String name, String qtype, String body) {
		int ret = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//SQL文:insert
		String sql = "insert into inquiry values(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, qtype);
			ps.setString(3, body);
			//登録件数＝i
			int i = ps.executeUpdate();

//iの値が0より大きいときメッセージを出力
			if(i>0) {
				System.out.println(i + "件登録されました");
				ret = i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}



}
