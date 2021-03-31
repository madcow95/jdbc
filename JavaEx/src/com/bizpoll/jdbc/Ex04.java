package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex04 {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@192.168.4.9:1521:xe";
			Connection con = DriverManager.getConnection(url, "scott", "1234");
			System.out.println("���Ӽ���");

			Statement st = con.createStatement();
			String sql = "SELECT *"
					+ "FROM tblMember";

			ResultSet result = st.executeQuery(sql);

			// next() : sql�� ������� resultSet�� �����ϴ°� ���پ� �ҷ����µ� ������ true ������ false���� �����ͼ� false�� ���ö����� �ݺ�
			while(result.next()) {
				int no = result.getInt("no"); // db�� no �÷��� datatype�� number�̴ϱ� int type���� ������ ��Ű�� �Ű���? db���� WHERE���ΰ�?
				String name = result.getString("name");
				int age = result.getInt("age");
				String addr = result.getString("addr");
				String phone = result.getString("phone");

				System.out.println(no + " " + name + " " + age + " " + addr + " " + phone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
// ���������� ����ؼ� ������ �Ⱦ��� (statement)