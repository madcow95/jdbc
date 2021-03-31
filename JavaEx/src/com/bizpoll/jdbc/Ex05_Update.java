package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Ex05_Update {
	
	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@192.168.4.9:1521:xe";
		String user = "scott";
		String pw = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);
			System.out.println("DB�� �����ϼ̽��ϴ�.");
			
			String sql = "UPDATE tblMember "
					+ "SET age = ?, phone = ? "
					+ "WHERE no = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, 31);				// literal ����
			pstmt.setString(2, "01098765432");
			pstmt.setInt(3, 7);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("�����Ϸ�");
			} else {
				System.out.println("��������");
			}
				
		} catch (Exception e) {
			
		}
	}

}
