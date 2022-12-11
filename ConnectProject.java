package com.test.project1;

import java.sql.Connection;  
import java.sql.DriverManager;

public class ConnectProject {
	Connection con = null;
	public Connection getConnectionDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://LocalHost: 3306/mcq","root","Root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
