package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	public static Connection createConnection(){
		Connection conn = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/automobile";
		String username = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
