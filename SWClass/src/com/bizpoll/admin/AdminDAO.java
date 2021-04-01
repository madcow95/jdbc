package com.bizpoll.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bizpoll.common.DBManager;
/*
 * admin 등록
 * 아이디 체크
 * 로그인
 */
public class AdminDAO {
	AdminDTO aDto;
	Connection con;
	PreparedStatement pstmt;
	Scanner scan;
	ResultSet rs;
	List<AdminDTO> adminList;
	public AdminDAO() {
		scan = new Scanner(System.in);
	}
	
	public int makeAdmin() {
		System.out.println("아이디 생성");
		System.out.println("==============");
		System.out.print("ID : ");
		String id = scan.nextLine();
		System.out.print("PW : ");
		String pw = scan.nextLine();
		System.out.print("NAME : ");
		String name = scan.nextLine();
		System.out.print("PHONE : ");
		String phone = scan.nextLine();
		
		aDto = new AdminDTO(id, pw, name, phone);
		con = DBManager.getConnection();
		String sql = "INSERT INTO admin VALUES(?, ?, ?, ?)";
		int succ = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, aDto.getId());
			pstmt.setString(2, aDto.getPw());
			pstmt.setString(3, aDto.getName());
			pstmt.setString(4, aDto.getPhone());
			
			succ = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(con, pstmt);
		}
		return succ;
	}
	
	
	public List<AdminDTO> checkId(String adminId) {
		aDto = new AdminDTO();
		aDto.setId(adminId);
		con = DBManager.getConnection();
		String sql = "SELECT  * " + 
				"FROM    admin " + 
				"WHERE   id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adminId);
			rs = pstmt.executeQuery();
			adminList = new ArrayList<AdminDTO>();
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				AdminDTO aDto = new AdminDTO(id, pw, name, phone);
				adminList.add(aDto);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return adminList;
	}
	
	public List<AdminDTO> login(String id, String pw) {
		aDto = new AdminDTO();
		aDto.setId(id);
		aDto.setPw(pw);
		con = DBManager.getConnection();
		String sql = "SELECT  * " + 
				"FROM    admin " + 
				"WHERE   id = ? AND pw = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, aDto.getId());
			pstmt.setString(2, aDto.getPw());
			rs = pstmt.executeQuery();
			adminList = new ArrayList<AdminDTO>();
			while(rs.next()) {
				String name = rs.getString("name");
				AdminDTO aDto = new AdminDTO();
				aDto.setName(name);
				adminList.add(aDto);
			}
			
		} catch (Exception e) {
			
		}
		finally{
			DBManager.close(con, pstmt, rs);
		}
		return adminList;
	}
	
	public boolean adminICheck(String id) {
		int resultCnt = 0;
		boolean useYN = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT count(name) "
				   + "FROM admin "
				   + "WHERE id = ?";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resultCnt = rs.getInt("count(name)");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		if (resultCnt == 0) {
			useYN = true;
		} 
		return useYN;
	}

}
