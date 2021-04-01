package com.jdbc.again;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	// 1. 관리자 등록 2. 관리자 로그인 3. 관리자 목록 4. 시스템 종료
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<DTO> adminList = new ArrayList<DTO>();
		while (true) {

			System.out.println("===============");
			System.out.println("1. 관리자 등록");
			System.out.println("2. 관리자 로그인");
			System.out.println("3. 관리자 목록");
			System.out.println("4. 시스템 종료");
			System.out.println("===============");
			System.out.print("입력 >> ");
			String strSelect = scan.nextLine();
			int select = Integer.valueOf(strSelect);
			DAO dao = new DAO();
			if (select >= 1 && select <= 4) {
				if (select == 1) {
					System.out.println("관리자 등록");
					System.out.println("==================");
					System.out.print("ID : ");
					String adminId = scan.nextLine();

					int result = dao.insert(adminId);
					if (result > 0) {
						System.out.println("이미 존재하는 아이디 입니다.");
					} else {
						System.out.println("회원가입이 완료 되었습니다");
					}
				} else if (select == 2) {
					System.out.println("로그인");
					System.out.println("===========");
					System.out.print("ID : ");
					String adminId = scan.nextLine();
					System.out.print("PW : ");
					String adminPw = scan.nextLine();
					adminList = dao.login(adminId, adminPw);
					if (adminList.size() > 0) {
						for (int i = 0; i < adminList.size(); i++) {
							System.out.println(adminList.get(i).getName() + "님 환영합니다");
						}
					} else {
						System.out.println("존재하지 않는 회원입니다.");
					}
				} else if (select == 3) {
					System.out.println("회원 목록");
					System.out.println("==========");
					adminList = dao.userList();
					if (adminList.size() > 0) {
						for (int i = 0; i < adminList.size(); i++) {
							System.out.println(adminList.get(i).getName() + "의 정보");
							System.out.printf("%s %s %s %s\n",
									adminList.get(i).getId(),
									adminList.get(i).getPw(),
									adminList.get(i).getName(),
									adminList.get(i).getPhone());
						}
					} else {
						System.out.println("회원 목록이 비어있습니다");
					}
				} else if (select == 4) {
					System.out.println("시스템 종료");
					break;
				}
			} else {
				System.out.println("1 ~ 4의 숫자만 입력하세요");
			}
		}
	}
}
