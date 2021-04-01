package com.jdbc.again;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.web.dbm.DBManager;

public class DAO {
	/*
	 * admin 등록 아이디 체크 로그인 관리자 목록
	 */
	PreparedStatement pstmt = null;
	Connection con = null;
	ResultSet rs = null;
	Scanner scan;
	List<DTO> adminList;
	public DAO() {
		scan = new Scanner(System.in);
	}

	public int insert(String adminId) {
		int succ = 0;
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * "
					+ "FROM admin "
					+ "WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adminId);
			succ = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (succ > 0) {
			return succ;
		} else {
			try {
				System.out.println(adminId + "는 사용가능한 아이디");
				System.out.print("PW : ");
				String adminPw = scan.nextLine();
				System.out.print("NAME : ");
				String adminName = scan.nextLine();
				System.out.print("PHONE : ");
				String adminPhone = scan.nextLine();
				con = DBManager.getConnection();
				String sql = "INSERT INTO admin "
							+ "VALUES(?, ?, ?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, adminId);
				pstmt.setString(2, adminPw);
				pstmt.setString(3, adminName);
				pstmt.setString(4, adminPhone);
				pstmt.executeUpdate();
			} catch (Exception e) {

			} finally {
				DBManager.close(con, pstmt);
			}
			return 0;
		}
	}

	public List<DTO> login(String id, String pw) {
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * "
					+ "FROM admin "
					+ "WHERE id = ? AND pw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			adminList = new ArrayList<DTO>();
			while(rs.next()) {
				String name = rs.getString("name");
				DTO dto = new DTO();
				dto.setName(name);
				adminList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		return adminList;
	}

	public List<DTO> userList() {
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * "
					+ "FROM admin ";
					
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			adminList = new ArrayList<DTO>();
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				DTO dto = new DTO(id, pw, name, phone);
				adminList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminList;
	}

}
