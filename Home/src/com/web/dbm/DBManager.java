package com.web.dbm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	private static Connection con;
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@220.93.161.202:1521:xe";
	private static final String USER = "scott";
	private static final String PW = "1234";
	
	private DBManager() {
		
	}
	
	public static Connection getConnection() {
		con = null;
		
		if(con == null) {
			try {
				Class.forName(DRIVER);
				con = DriverManager.getConnection(URL, USER, PW);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			}
		}
	}
}
