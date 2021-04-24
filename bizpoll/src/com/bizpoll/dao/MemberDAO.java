package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bizpoll.common.DBManager;
import com.bizpoll.dto.MemberDTO;

public class MemberDAO {
	
	private MemberDAO() {
		
	}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public MemberDTO getMember(String userId) {
		
		MemberDTO mDto = null;
		
		String sql = "SELECT id,pwd,name "
				   + "FROM member "
				   + "WHERE id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mDto = new MemberDTO();
				/* mDto.setName(rs.getString("name")); */
				mDto.setId(rs.getString("id"));
				mDto.setPwd(rs.getString("pwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mDto;
	}
	
public ArrayList<MemberDTO> getMember2(String userId) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDTO mDto = null;
		
		String sql = "SELECT * "
				   + "FROM member "
				   + "WHERE id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mDto = new MemberDTO();
				mDto.setName(rs.getString("name"));
				mDto.setId(rs.getString("id"));
				mDto.setPwd(rs.getString("pwd"));
				list.add(mDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public void deleteMember(String id, String pwd) {
		
		String sql = "DELETE FROM member "
				   + "WHERE id = ? "
				   + "AND pwd = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void join(String id, String pwd, String name, String email, String address, String phone, String zip_num) {
		//회원가입
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member(id, pwd, name, email, address, phone, zip_num) " + 
				     "VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.setString(5, address);
			pstmt.setString(6, phone);
			pstmt.setString(7, zip_num);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	public int join2(MemberDTO mDto) {
		//회원가입
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member(id, pwd, name, email, address, phone, zip_num) " + 
				     "VALUES(?, ?, ?, ?, ?, ?, ?)";
		int result = -1;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getId());
			pstmt.setString(2, mDto.getPwd());
			pstmt.setString(3, mDto.getName());
			pstmt.setString(4, mDto.getEmail());
			pstmt.setString(5, mDto.getAddress());
			pstmt.setString(6, mDto.getPhone());
			pstmt.setString(7, mDto.getZip_num());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public int confirmID(String userID) {
		// 회원 가입 여부 판별 변수
		int result = -1;
		
		String sql = "SELECT * "
				   + "FROM member "
				   + "WHERE id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1; // 회원가입 불가능 --> db에 같은 id를 가진 회원이 존재한다
			} else {
				result = -1; // 회원가입 가능
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public void update(String id, String pwd, String changePwd) {
		String sql = "UPDATE member " + 
				"SET pwd = ? " + 
				"WHERE id = ? " + 
				"AND pwd = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, changePwd);
			pstmt.setString(2, id);
			pstmt.setString(3, pwd);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
