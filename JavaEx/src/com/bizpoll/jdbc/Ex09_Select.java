package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bizpoll.dto.MemberDTO;

public class Ex09_Select {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("검색할 회원 이름 : ");
		String name = scan.nextLine();
		
		MemberDTO mDto = new MemberDTO();
		mDto.setName(name);
		scan.close();
		
		List<MemberDTO> result = memSelect(mDto);
		System.out.println(result);
	}

	private static List<MemberDTO> memSelect(MemberDTO mDto) {
		List<MemberDTO> memList = new ArrayList<MemberDTO>();;
		String url = "jdbc:oracle:thin:@192.168.4.9:1521:xe";
		String user = "scott";
		String pw = "1234";
		int succ = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection(url, user, pw);
			Statement st = con.createStatement();
			String sql = "SELECT * " + 
					"FROM tblMember " + 
					"WHERE name = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mDto.getName());
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String phone = rs.getString("phone");
				
				System.out.printf("%d %s %d %s %s",no, name, age, addr, phone);
				
				mDto.setNo(no);
				mDto.setName(name);
				mDto.setAge(age);
				mDto.setAddr(addr);
				mDto.setPhone(phone);
				memList.add(mDto);
			}
		} catch (Exception e) {
			
		}
		return memList;
	}

}
