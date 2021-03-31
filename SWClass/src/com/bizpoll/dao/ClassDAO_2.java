package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bizpoll.common.DBManager;
import com.bizpoll.dto.ClassDTO02;

public class ClassDAO_2{
	private String url;
	private String forName;
	private String user;
	private String pw;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private Connection con = null;
	private List<ClassDTO02> classList;
	
	public ClassDAO_2() {
		forName = "oracle.jdbc.driver.OracleDriver";
		url = "jdbc:oracle:thin:@192.168.4.9:1521:xe";
		user = "scott";
		pw = "1234";
	}

	public List<ClassDTO02> search(String searchName) {
		try {
			Class.forName(forName);
			con = DriverManager.getConnection(url, user, pw);

			String sql = "SELECT * " + "FROM tblmember " + "WHERE name LIKE ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + searchName + "%");
			rs = pstmt.executeQuery();
			classList = new ArrayList<ClassDTO02>();
			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String phone = rs.getString("phone");

				ClassDTO02 cDto2 = new ClassDTO02(no, name, age, addr, phone);
				classList.add(cDto2);
			}
		} catch (Exception e) {

		} DBManager.close(con, pstmt);
		return classList;
	}
}
