package com.hcl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection()
	{
		Connection con = null;;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String jdbcurl="jdbc:oracle:thin:@localhost:1521:xe";
			String user="jagadish";
			String pass="satya";
			con=DriverManager.getConnection(jdbcurl,user,pass);
			System.out.println("connection success");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return(con);
	}
}
