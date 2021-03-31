package com.bizpoll.javaex;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Exercise3_012 {
	/*
	 * 요구 사항 1. 입력값을 문자열로 취득(메뉴 선택시) 메뉴 : 1을 입력시 게임시작 2를 입력시 게임종료(System.exit(0)을
	 * 이용할것) 2. 종료하겠다는 의미의 숫자를 입력하지 않으면 선택 메뉴가 계속 표시 3. 주사위 판정을 위한 사용자로부터 1 ~ 6사이의
	 * 값을 취득 (유효성 체크 그 외의 값이 취득되면 계속 반복해서 입력값 체크 4. 컴퓨터는 랜덤하게 숫자를 취득(1 ~ 6)
	 */

	public static void main(String args[]) {
		Random rnd = new Random();
		Scanner scan = new Scanner(System.in);
		while (true) {
			int comDice = rnd.nextInt(6) + 1;
			System.out.println("게임시작 : 1 / 게임종료 : 2");
			System.out.print("입력 >> ");
			
			while(true) {
				try {
					String strSelect = scan.nextLine();
					int select = Integer.valueOf(strSelect);
					if (select >= 1 && select <= 2) {
						if (select == 1) {
							System.out.println("숫자 입력 (1 ~ 6)");
							System.out.print("입력 >> ");
							String strDice = scan.nextLine();
							int dice = Integer.valueOf(strDice);
							
							System.out.println("user : " + dice);
							System.out.println("com : " + comDice);
							if (dice >= 1 && dice <= 6) {
								if (dice > comDice) {
									System.out.println("user 승리");
								} else if (dice == comDice) {
									System.out.println("무승부");
								} else if (dice < comDice) {
									System.out.println("com 승리");
								}
								break;
							} else {
								System.out.println("dice는 1 ~ 6만 입력해주세요");
								break;
							}

						} else if (select == 2) {
							System.out.println("게임종료");
							break;
						}
					} else {
						System.out.println("1 ~ 2만 입력하세요");
						System.out.print("재입력 >> ");
					}
				} catch (Exception e) {
					System.out.println("숫자만 입력해주세요");
					break;
				}
			}break;
			

		}

	}
}
