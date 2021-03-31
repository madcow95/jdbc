package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex05_Insert {
// PreparedStatement

	public static void main(String args[]) {
		String url = "jdbc:oracle:thin:@192.168.4.9:1521:xe";
		String user = "scott";
		String pw = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);
			System.out.println("DB에 접속하셨습니다.");

			String sql = "INSERT INTO tblMember VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql); // 바인드 변수 : 성능과 보안을 위해 사용 / injection공격으로부터 안전
			pstmt.setInt(1, 7); // prepared statement의 set은 1부터 시작 0부터시작 아님(a,b)에서 a는 몇번째 ?에 추가할거냐 b는 어떤 값을 넣을거냐 
			pstmt.setString(2, "김보리");
			pstmt.setInt(3, 50);
			pstmt.setString(4, "광주광역시 북구 중흥동");
			pstmt.setString(5, "00000000000");

			int result = pstmt.executeUpdate();

			if(result > 0) {
				System.out.println("회원가입 성공!");
			} else {
				System.out.println("회원가입 실패!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}