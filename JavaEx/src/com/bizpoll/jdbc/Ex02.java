package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ex02 {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@192.168.4.9:1521:xe";
			Connection con = DriverManager.getConnection(url, "scott", "1234");
			System.out.println("접속성공");
			
			Statement st = con.createStatement();
			String sql = "UPDATE tblMember"
					+ " SET age = 31, phone = '01098765432'"
					+ " WHERE no = 6";
			int result = st.executeUpdate(sql);
			
			if(result > 0) {
				System.out.println("수정성공");
			} else {
				System.out.println("수정실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
