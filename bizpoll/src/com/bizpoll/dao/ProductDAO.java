package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bizpoll.common.DBManager;
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
	 * 		  p_img FROM (SELECT rownum,
	 * 							 p_code,
	 * 							 p_name,
	 * 							 p_price2,
	 * 							 p_img
	 * 					  FROM 	 product
	 * 					  WHERE p_bestyn = 'y'
	 * 					  ORDER BY p_indate desc)
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
			
			while(rs.next()) {
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
}
