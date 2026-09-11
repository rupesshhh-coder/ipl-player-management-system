package com.tka.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyDbCong {

	public static Connection getMyConnect() {

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/ipl";
			String mysqlId = "root";
			String pass = "MYSQL333";

			con = DriverManager.getConnection(url, mysqlId, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
