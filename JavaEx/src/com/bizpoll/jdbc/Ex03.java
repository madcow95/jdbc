package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ex03 {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@192.168.4.9:1521:xe";
			Connection con = DriverManager.getConnection(url, "scott", "1234");
			System.out.println("접속성공");

			Statement st = con.createStatement();
			
			String sql = "DELETE FROM tblMember WHERE age = 31";
			int result = st.executeUpdate(sql);
			if(result > 0) {
				System.out.println("삭제완료");
			} else {
				System.out.println("삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
