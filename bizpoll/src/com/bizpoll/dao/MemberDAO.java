package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bizpoll.common.DBManager;
import com.bizpoll.dto.MemberDTO;
import com.bizpoll.mybatis.SqlMapConfig;

public class MemberDAO {
	
	private MemberDAO() {
		
	}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	
	public int batisJoin(MemberDTO mDto) {
		
		sqlSession = sqlSessionFactory.openSession();
		int result = 0;
		try {
			result = sqlSession.insert("joinList", mDto);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	public MemberDTO getMember(String userId) {
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
			System.out.println("test id > " + userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mDto = new MemberDTO();
				mDto.setId(rs.getString("id"));
				mDto.setPwd(rs.getString("pwd"));
				mDto.setName(rs.getString("name"));
				mDto.setEmail(rs.getString("email"));
				mDto.setAddress(rs.getString("address"));
				mDto.setPhone(rs.getString("phone"));
				mDto.setZip_num(rs.getString("zip_num"));
				System.out.println("dao DTO > " + mDto.toString());
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
		//????????????
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
		//????????????
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
		// ?????? ?????? ?????? ?????? ??????
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
				result = 1; // ???????????? ????????? --> db??? ?????? id??? ?????? ????????? ????????????
			} else {
				result = -1; // ???????????? ??????
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
	
	public MemberDTO mybatisLogin(String id){
		
		sqlSession = sqlSessionFactory.openSession();
		MemberDTO mDto = null;
		
		try {
			mDto = sqlSession.selectOne("userId",id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return mDto;
	}
	
	public List<MemberDTO> findId()	{
		
		sqlSession = sqlSessionFactory.openSession();
		
		List<MemberDTO> memList = null;
		
		try {
			memList = sqlSession.selectList("findIdList");
			System.out.println("memList size = " + memList.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return memList;
	}
}
