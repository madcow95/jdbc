package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bizpoll.common.DBManager;
import com.bizpoll.dto.BoardDTO;
import com.bizpoll.mybatis.SqlMapConfig;

public class BoardDAO {
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	
	
	public List<BoardDTO> boardList() {
		
		sqlSession = sqlSessionFactory.openSession();
		
		List<BoardDTO> boardList = null;
		
		try {
			boardList = sqlSession.selectList("selBoardList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return boardList;
	}

	public Integer getNewArticleNo() {
		sqlSession = sqlSessionFactory.openSession(); // 세션이 열린다?
		
		Integer articleNo = 0;
		
		try {
			articleNo = sqlSession.selectOne("getNewArticleNo");
			System.out.println("articleNo = " + articleNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return articleNo;
	}
	
	public int create(BoardDTO bDto) {
		
		sqlSession = sqlSessionFactory.openSession();
		
		int result = 0;
		
		try {
			result = sqlSession.insert("creatBoard", bDto);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return result;
	}
	
	public BoardDTO getBoard(String artNo) {
		
		String sql = "SELECT * FROM board WHERE articleno = ?";
		BoardDTO bDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, artNo);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bDto = new BoardDTO();
				bDto.setArticleno(rs.getInt("articleno"));
				bDto.setSubject(rs.getString("subject"));
				bDto.setContent(rs.getString("content"));
				bDto.setFilename(rs.getString("filename"));
				bDto.setRef(rs.getInt("ref"));
				bDto.setId(rs.getString("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return bDto;
	}
	
	public int boardDel(String id, String article) {
		
		String sql = "DELETE FROM board " + 
				"WHERE articleno = ? " + 
				"AND id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public BoardDTO selBoardView(int articleno) {
		BoardDTO bDto = null;
		
		sqlSession = sqlSessionFactory.openSession(); // 세션객체를 얻어와서 mybatis를 호출한다
		
		try {
			bDto = sqlSession.selectOne("selectBoardView", articleno); // selectBoardView에 articleno(파라미터값)을 보내는거같다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return bDto;
	}
	
	public int modify(BoardDTO bDto) {
		sqlSession = sqlSessionFactory.openSession();
		
		int result = 0;
		try {
			result = sqlSession.update("modifyBoard", bDto);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
}
