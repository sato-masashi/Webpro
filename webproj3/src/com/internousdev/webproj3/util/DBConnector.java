package com.internousdev.webproj3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {
	/**
	 * JDBCﾄﾞﾗｲﾊﾞｰ
	 */

	private static String driverName = "com.mysql.jdbc.Driver";
	/**
	 * ﾃﾞｰﾀﾍﾞｰｽ接続
	 */
	private static String url = "jdbc:mysql://localhost/testdb";
	/**
	 *ﾃﾞｰﾀﾍﾞｰｽ接続ﾕｰｻﾞ名
	 */
	private static String user = "root";
	/**
	 *ﾃﾞｰﾀﾍﾞｰｽ接続ﾊﾟｽﾜｰﾄﾞ
	 */
	private static String password = "mysql";



public Connection getConnection() {
	Connection con = null;

	try {

		Class.forName(driverName);
		con = DriverManager.getConnection(url,user,password);
	} catch (ClassNotFoundException e) {
		e.printStackTrace() ;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return con;


}

}
