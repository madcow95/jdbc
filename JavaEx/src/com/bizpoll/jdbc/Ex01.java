package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ex01 {

	public static void main(String[] args) {
		// io class , db class�� ���� �׻� ����ó��
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@192.168.4.9:1521:xe";
			Connection con = DriverManager.getConnection(url, "scott", "1234");
			System.out.println("���Ӽ���");

			Statement st = con.createStatement();

			String sql = "INSERT INTO tblMember VALUES (6, '�庸��', 27, '����� ������ û�㵿', '01022222222')";
			int result = st.executeUpdate(sql);
			if (result > 0) {
				System.out.println("��� ����");
			} else {
				System.out.println("��� ����");
			}

			// ���� 31, ��ȭ��ȣ 01098765432�� �����ϴ� ����� ����
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}