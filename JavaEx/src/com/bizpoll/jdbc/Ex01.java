package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ex01 {

	public static void main(String[] args) {
		// io class , db class를 쓸때 항상 예외처리
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@192.168.4.9:1521:xe";
			Connection con = DriverManager.getConnection(url, "scott", "1234");
			System.out.println("접속성공");

			Statement st = con.createStatement();

			String sql = "INSERT INTO tblMember VALUES (6, '장보리', 27, '서울시 강남구 청담동', '01022222222')";
			int result = st.executeUpdate(sql);
			if (result > 0) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}

			// 나이 31, 전화번호 01098765432로 수정하는 기능을 구현
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}