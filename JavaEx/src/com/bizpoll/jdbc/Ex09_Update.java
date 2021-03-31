package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.bizpoll.dto.MemberDTO;

public class Ex09_Update {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("수정할 회원 이름 입력 : ");
		String name = scan.nextLine();
		
		System.out.print("변경할 나이 : ");
		int age = scan.nextInt();
		scan.nextLine();
		
		System.out.print("변경된 전화번호 : ");
		String phone = scan.nextLine();
		
		MemberDTO mDto = new MemberDTO();
		mDto.setName(name);
		mDto.setAge(age);
		mDto.setPhone(phone);
		scan.close();
		
		int result = memUpdate(mDto);
		if(result > 0) {
			System.out.println("수정 완료");
		} else {
			System.out.println("수정 실패");
		}
		
	}

	private static int memUpdate(MemberDTO mDto) {
		String url = "jdbc:oracle:thin:@192.168.4.9:1521:xe";
		String user = "scott";
		String pw = "1234";
		int succ = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);

			String sql = "UPDATE tblMember " + 
					"SET age = ?, phone = ? " + 
					"WHERE name = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mDto.getAge());
			pstmt.setString(2, mDto.getPhone());
			pstmt.setString(3, mDto.getName());
			
			succ = pstmt.executeUpdate();
		} catch (Exception e) {
			
		}
		return succ;
	}

}
