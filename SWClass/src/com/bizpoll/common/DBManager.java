/*
 * ****************************************************
 *  @Source : DBManager.java
 *  @description : Connection객체를 얻어오고 사용이 끝난 리소스를 해제하는 클래스
 * ****************************************************
 * DATE			AUTHOR			DESCRIPTION
 * ----------------------------------------------------
 * 2021/03/31	최광우			최초작성
 * 2021/04/30	최광우			회원가입 기능 추가
 */
package com.bizpoll.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Singleton 클래스 : 인스턴스를 하나만 만들어서 사용하는 방법
public class DBManager {
	private static Connection con;
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@220.93.161.202:1521:xe";
	private static final String USER = "scott";
	private static final String PW = "1234";

	// 다른 클래스에서 접근을 못하게 막는다
	// 생성자 메소드를 다른 클래스에서 new로 새로 선언을 하면 DBManager도 사용할수있기 때문에 생성자에도 private을 건다.
	private DBManager() {
		
	}

	public static Connection getConnection() {
		con = null;

		if (con == null) {
			try {
				Class.forName(DRIVER);
				con = DriverManager.getConnection(URL, USER, PW);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	// 객체 개수가 다른 method의 이름은 중복이 가능하다 --> overloading
	public static void close(Connection con, PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
