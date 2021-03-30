package com.hel.ex;

import java.util.List;
import java.util.Scanner;

import com.hel.dao.WebDAO;
import com.hel.dto.WebDTO;

public class WebEx {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		WebDAO wDao = new WebDAO();
		while (true) {
			System.out.println("====================");
			System.out.println("Hell's Health 페이지");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원정보수정");
			System.out.println("4. 회원정보");
			System.out.println("5. 회원탈퇴");
			System.out.println("QUIT. 프로그램종료");
			System.out.println("====================");
			System.out.print("선택 >> ");
			String strSelect = scan.nextLine();
			if (strSelect.equalsIgnoreCase("q")) {
				System.out.println("프로그램 종료");
				break;
			}
			try {
				int select = Integer.valueOf(strSelect);
				if (select >= 1 && select <= 5) {
					if (select == 1) {
						int result = wDao.signin();
						if (result > 0) {
							System.out.println("회원가입 완료!!");
						} else {
							System.out.println("회원가입 실패");
						}
					} else if (select == 2) {
						String userId = wDao.login();
						if (userId == null) {
							System.out.println("잘못된 ID / PW입니다.");
						} else {
							System.out.printf("%s님 환영합니다\n", userId);
						}
					} else if (select == 3) {
						System.out.print("ID : ");
						String userId = scan.nextLine();
						System.out.print("PW : ");
						String userPw = scan.nextLine();
						int result = wDao.update(userId, userPw);
						if (result > 0) {
							System.out.println("정보수정 완료");
						} else {
							System.out.println("수정 실패");
						}
					} else if (select == 4) {
						System.out.print("ID : ");
						String selectId = scan.nextLine();
						System.out.print("PW : ");
						String selectPw = scan.nextLine();
						List<WebDTO> webList = wDao.select(selectId, selectPw);
						if (webList.size() > 0) {
							for (WebDTO wDto : webList) {
								System.out.printf("%s의 정보\n", wDto.getId());
								System.out.printf("%s %s %s %s %s %s\n",
										wDto.getId(),
										wDto.getPass(),
										wDto.getName(),
										wDto.getBirth(),
										wDto.getAddr(),
										wDto.getPhone());
							}
						} else {
							System.out.println("회원정보가 없습니다.");
						}
					} else if (select == 5) {
						System.out.print("탈퇴할 아이디 입력 : ");
						String delId = scan.nextLine();
						System.out.print("비밀번호 입력 : ");
						String delPw = scan.nextLine();
						int delResult = wDao.delete(delId, delPw);
						if (delResult > 0) {
							System.out.println("탈퇴완료");
						} else {
							System.out.println("탈퇴실패");
						}
					}
				} else {
					System.out.println("1 ~ 5의 숫자만 입력해주세요");
				}

			} catch (Exception e) {
				System.out.println("1 ~ 5의 숫자 또는 종료를위한 q를 입력해주세요");
			}

		}

	}

}
