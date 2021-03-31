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
			System.out.println("DB�� �����ϼ̽��ϴ�.");

			String sql = "INSERT INTO tblMember VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql); // ���ε� ���� : ���ɰ� ������ ���� ��� / injection�������κ��� ����
			pstmt.setInt(1, 7); // prepared statement�� set�� 1���� ���� 0���ͽ��� �ƴ�(a,b)���� a�� ���° ?�� �߰��Ұų� b�� � ���� �����ų� 
			pstmt.setString(2, "�躸��");
			pstmt.setInt(3, 50);
			pstmt.setString(4, "���ֱ����� �ϱ� ���ﵿ");
			pstmt.setString(5, "00000000000");

			int result = pstmt.executeUpdate();

			if(result > 0) {
				System.out.println("ȸ������ ����!");
			} else {
				System.out.println("ȸ������ ����!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}