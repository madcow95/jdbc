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
			System.out.println("접속성공");

			Statement st = con.createStatement();
			String sql = "SELECT *"
					+ "FROM tblMember";

			ResultSet result = st.executeQuery(sql);

			// next() : sql의 결과값을 resultSet에 저장하는걸 한줄씩 불러오는데 있으면 true 없으면 false값을 가져와서 false가 나올때까지 반복
			while(result.next()) {
				int no = result.getInt("no"); // db의 no 컬럼의 datatype은 number이니까 int type으로 저장을 시키는 거겠지? db에서 WHERE절인가?
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
// 보안적으로 취약해서 요즘은 안쓴다 (statement)