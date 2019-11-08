package com.internousdev.webproj5.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	/**
	 * driverName = "JDBCドライバー名"
	 */
	private static String driverName = "com.mysql.jdbc.Driver";

	/**
	 * url = "データベース接続URL"
	 */
	private static String url = "jdbc:mysql://localhost/testdb";

	/**
	 * user = "データベース接続ユーザ名"
	 */
	private static String user ="root";

	/**
	 * password = "データベース接続パスワード"
	 */
	private static String password ="mysql";

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return con;
	}
}
