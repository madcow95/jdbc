package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex05_Select {
	
	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@192.168.4.9:1521:xe";
		String user = "scott";
		String pw = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);
			System.out.println("DB에 접속하셨습니다.");
			Statement st = con.createStatement();

			String sql = "SELECT * "
					+ "FROM tblMember WHERE no = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery(sql);

			pstmt.setInt(1, 6);
			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String phone = rs.getString("phone");

				System.out.println(no + " " + name + " " + age + " " + addr + " " + phone);
			}
		} catch (Exception e) {

		}

	}

}
