package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.bizpoll.dto.MemberDTO;

public class Ex09_Delete {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름 입력 : ");
		String name = scan.nextLine();
		MemberDTO mDto = new MemberDTO();
		mDto.setName(name);
		scan.close();
		int result = memDelete(mDto);
		
		if(result > 0) {
			System.out.println("삭제완료");
		} else {
			System.out.println("삭제실패");
		}
	}

	public static int memDelete(MemberDTO mDto) {
		String url = "jdbc:oracle:thin:@192.168.4.9:1521:xe";
		String user = "scott";
		String pw = "1234";
		
		int conn = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);
			String sql = "DELETE FROM tblMember WHERE name = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mDto.getName());
			int result = pstmt.executeUpdate();
			conn = result;
		} catch (Exception e) {
			
		}
		return conn;
	}

}
