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
	 * user = "データベース接続ユーザー名"
	 */
	private static String user = "root";

	/**
	 * password = "データベース接続PW"
	 */
	private static String password = "mysql";


	public Connection getConnection() {
		Connection con = null;

		try {
			/**
			 * 指定された文字列名を持つクラスまたはインタフェースに関連付けられた、
			 * Classオブジェクトを返す
			 */
			Class.forName(driverName);
			con = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/**
		 * con = getConnectionメソッドで
		 * 接続url, 接続user, 接続password を取得
		 */
		return con;
	}



}
