package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bizpoll.common.DBManager;
import com.bizpoll.dto.MemberDTO;
import com.bizpoll.dto.ProductDTO;

public class ProductDAO {

	private ProductDAO() {

	}

	private static ProductDAO instance = new ProductDAO();

	public static ProductDAO getInstance() {
		return instance;
	}

	/*
	 * SELECT p_code,
	 * 		  p_name,
	 * 		  p_price2,
	 * 		  p_img
	 * FROM (SELECT rownum,
	 * 			    p_code,
	 * 			    p_name,
	 * 				p_price2,
	 * 				p_img
	 * 		 FROM 	product
	 * 		 WHERE p_bestyn = 'y'
	 * 		 ORDER BY p_indate desc)
	 * WHERE rownum <= 4;
	 * 원문 코드
	 */

	public ArrayList<ProductDTO> listNewProduct() {

		// 신상품 추출 sql
		String sql = "SELECT * FROM new_pro_view";
		ArrayList<ProductDTO> newProductList = new ArrayList<ProductDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductDTO pDto = new ProductDTO();
				pDto.setP_code(rs.getString("p_code"));
				pDto.setP_name(rs.getString("p_name"));
				pDto.setP_price2(rs.getInt("p_price2"));
				pDto.setP_img(rs.getString("p_img"));

				newProductList.add(pDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return newProductList;
	}

	public ArrayList<ProductDTO> listBestProduct() {
		ArrayList<ProductDTO> bestProductList = new ArrayList<ProductDTO>();

		String sql = "SELECT * " + "FROM best_pro_view";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductDTO pDto = new ProductDTO();
				pDto.setP_code(rs.getString("p_code"));
				pDto.setP_name(rs.getString("p_name"));
				pDto.setP_price2(rs.getInt("p_price2"));
				pDto.setP_img(rs.getString("p_img"));

				bestProductList.add(pDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bestProductList;
	}

	public ProductDTO productDetail(String p_code) {
		ProductDTO pDto = new ProductDTO();

		String sql = "SELECT * " + "FROM product " + "WHERE p_code = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_code);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pDto.setP_code(rs.getString("p_code"));
				pDto.setP_name(rs.getString("p_name"));
				pDto.setP_kind(rs.getString("p_kind"));
				pDto.setP_price1(rs.getInt("p_price1"));
				pDto.setP_price2(rs.getInt("p_price2"));
				pDto.setP_price3(rs.getInt("p_price3"));
				pDto.setP_content(rs.getString("p_content"));
				pDto.setP_img(rs.getString("p_img"));
				pDto.setP_useyn(rs.getString("p_useyn"));
				pDto.setP_bestyn(rs.getString("p_bestyn"));
				pDto.setP_indate(rs.getDate("p_indate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pDto;
	}
	
	public void join(String id, String pwd, String name, String email, String addr, String phone, String zip_num) {
		String sql = "INSERT INTO member(id, pwd, name, email, address, phone, zip_num) "
				   + "VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.setString(5, addr);
			pstmt.setString(6, phone);
			pstmt.setString(7, zip_num);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public MemberDTO login(String id, String pwd) {
		MemberDTO pDto = new MemberDTO();
		
		String sql = "SELECT name "
				   + "FROM member "
				   + "WHERE id = ? "
				   + "AND pwd = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pDto.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pDto;
	}
}
