package com.bizpoll.jdbc;

import java.util.List;
import java.util.Scanner;

import com.bizpoll.dao.MemberDAO;
import com.bizpoll.dto.MemberDTO;

public class ExMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberDAO mDao = new MemberDAO();
		while(true) {
			
			System.out.println("=============================");
			System.out.println("xxx사이트");
			System.out.println("1. 회원가입");
			System.out.println("2. 회원탈퇴");
			System.out.println("3. 회원정보 수정");
			System.out.println("4. 회원정보 불러오기");
			System.out.println("5. 로그인");
			System.out.println("QUIT. 프로그램종료");
			System.out.println("-----------------------------");
			System.out.print("입력 >> ");
			String strSelect = scan.nextLine();
			if(strSelect.equalsIgnoreCase("q")) {
				break;
			}
			try {
				int select = Integer.valueOf(strSelect);
				if (select >= 1 && select <= 5) {
					if (select == 1) {
						mDao.insert();
					} else if (select == 2) {
						mDao.delete();
					} else if (select == 3) {
						mDao.update();
					} else if (select == 4) {
						System.out.print("조회할 회원번호 >> ");
						int memberSelect = scan.nextInt();
						List<MemberDTO> memList = mDao.select(memberSelect);
						if (memList.size() > 0) {
							for (MemberDTO memberDTO : memList) {
								System.out.println(memberSelect + "번 회원의 정보");
								System.out.printf("%d %s %d %s %s\n",memberDTO.getNo(),
										memberDTO.getName(),
										memberDTO.getAge(),
										memberDTO.getAddr(),
										memberDTO.getPhone());
							}
						} else {
							System.out.println("등록되지 않은 회원입니다..");
						}
					} else if(select == 5) {
						System.out.print("이름입력 : ");
						String name = scan.nextLine();
						int succ = mDao.login(select);
						List<MemberDTO> memList = mDao.userId(name);
						if(succ > 0) {
							System.out.printf("%s님 환영합니다\n");
						} else {
							System.out.println("이름 / 번호를 다시 확인해주세요");
						}
						break;
					}
				} else {
					System.out.println("1 ~ 5에서만 입력하세요");
				}
			} catch (Exception e) {
				System.out.println("1 ~ 5, q만 입력해주세요");
			}
		}
	}

}
