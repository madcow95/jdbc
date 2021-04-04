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
			System.out.println("4. 관리자 정보수정");
			System.out.println("5. 회원 검색");
			System.out.println("6. 회원 탈퇴");
			System.out.println("7. 시스템 종료");
			System.out.println("===============");
			System.out.print("입력 >> ");
			String strSelect = scan.nextLine();
			int select = Integer.valueOf(strSelect);
			DAO dao = new DAO();
			if (select >= 1 && select <= 7) {
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
					System.out.println("정보수정");
					System.out.println("=============");
					System.out.print("회원ID : ");
					String updateId = scan.nextLine();
					System.out.print("회원PW : ");
					String updatePw = scan.nextLine();
					int result = dao.update(updateId, updatePw);
					if(result > 0) {
						System.out.println("수정이 완료되었습니다.");
					} else {
						System.out.println("존재하지 않는 회원입니다.");
					}
				} else if (select == 5){
					System.out.println("회원 검색");
					System.out.println("=============");
					System.out.print("이름 : ");
					String searchUser = scan.nextLine();
					int result = dao.search(searchUser);
					System.out.printf("검색결과가 %d건 있습니다\n",
								result);
				} else if (select == 6){
					System.out.println("회원 탈퇴");
					System.out.println("==============");
					System.out.print("ID : ");
					String deleteId = scan.nextLine();
					System.out.print("PW : ");
					String deletePw = scan.nextLine();
					boolean bYes = dao.delete(deleteId, deletePw);
					if (bYes == true) {
						System.out.println("회원 탈퇴 완료");
					} else {
						System.out.println("존재하지 않는 회원입니다.");
					}
				} else if (select == 7) {
					System.out.println("시스템 종료");
					break;
				}
			} else {
				System.out.println("1 ~ 7의 숫자만 입력하세요");
			}
		}
	}
}
