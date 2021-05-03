package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

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
	
	
	/*
	 * public List<BoardDTO> boardList(Map<String, Integer> paginMap) {
	 * 
	 * sqlSession = sqlSessionFactory.openSession();
	 * 
	 * List<BoardDTO> boardList = null;
	 * 
	 * try {
	 *  boardList = sqlSession.selectList("selBoardList",paginMap); }
	 *   catch (Exception e) { 
	 *   e.printStackTrace(); 
	 *   } finally { 
	 *   sqlSession.close(); 
	 *   } 
	 *   return boardList; 
	 *   }
	 */
	
	public List<BoardDTO> boardList(Map<String, Object> searchType) {
		
		sqlSession = sqlSessionFactory.openSession();
		
		List<BoardDTO> boardList = null;
		
		try {
			boardList = sqlSession.selectList("selBoardList",searchType);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return boardList;
	}
	
//	public int boardListAllCnt() {
//		sqlSession = sqlSessionFactory.openSession();
//		int boardListAllCnt = 0;
//		try {
//			boardListAllCnt = sqlSession.selectOne("boardListAllCnt");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			sqlSession.close();
//		}
//		return boardListAllCnt;
//	}
	
	public int boardListAllCnt(Map<String, Object> boardParm) {
		sqlSession = sqlSessionFactory.openSession();
		int boardListAllCnt = 0;
		try {
			boardListAllCnt = sqlSession.selectOne("boardListAllCnt", boardParm);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return boardListAllCnt;
	}

	public Integer getNewArticleNo() {
		sqlSession = sqlSessionFactory.openSession(); // 세션이 열린다?
		
		Integer articleNo = 0;
		
		try {
			articleNo = sqlSession.selectOne("getNewArticleNo");
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
	
	public int boardDel(int article) {
		
		String sql = "DELETE FROM board " + 
				"WHERE articleno = ? ";
				
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, article);
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
	
	public int replyReStepUpdate(BoardDTO bDto) {
		
		sqlSession = sqlSessionFactory.openSession();
		int result = 0;
		
		try {
			int maxsOrder = sqlSession.selectOne("selectBoardReplyMaxOrder", bDto); // list : selectList , select
			System.out.println("maxsOrder >> " + maxsOrder);
			
			if(maxsOrder == 0) {
				int selectRestep = sqlSession.selectOne("selectRestep", bDto);
				int re_level = bDto.getRe_level() + 1;
				
				bDto.setRe_step(selectRestep);
				bDto.setRe_level(re_level);
				
				result = sqlSession.insert("creatBoard",bDto);
				sqlSession.commit();
			} else {
//				maxsOrder = sqlSession.selectOne("selectBoardReplyMaxOrder",bDto);
//				bDto.setRe_step(maxsOrder);
				
				sqlSession.update("replyRestepUpdate",bDto);
				bDto.setRe_step(bDto.getRe_step() + 1);
				
				int re_level = bDto.getRe_level() + 1;
				bDto.setRe_level(re_level);
				
				result = sqlSession.insert("creatBoard", bDto);
				sqlSession.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	/*
	 * public List<BoardDTO> selAllBoardList(){ List<BoardDTO> boardList = null;
	 * sqlSession = sqlSessionFactory.openSession(); try {
	 * 
	 * } catch (Exception e) { // TODO: handle exception } return boardList; }
	 */
	public void readcount(BoardDTO bDto) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			System.out.println("bDto articleno > "+bDto.getArticleno());
			System.out.println("bDto read > "+bDto.getReadcount());
			sqlSession.update("readcount",bDto);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
}
