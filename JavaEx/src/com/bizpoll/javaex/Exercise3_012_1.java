package com.bizpoll.javaex;

import java.util.Random;
import java.util.Scanner;

public class Exercise3_012_1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random rnd = new Random();

		while (true) {
			System.out.println("게임시작 : 1 / 게임종료 : 2");
			System.out.print("입력 >> ");
			int selItem = scan.nextInt();
			if (String.valueOf(selItem).equals("2")) { // "2".equals(String.valueOf(selItem));로 해도된다 문자열은 null값이 들어오면 안되기 때문에 숫자로 이루어진 문자열일경우 이렇게하는게 가장 안정적이다.
				System.out.println("게임 종료");
				System.exit(0);
			} else if (String.valueOf(selItem).equals("1")) {
				System.out.println("게임 시작");
				System.out.println("주사위 게임");
				System.out.println("1 ~ 6의 정수만 입력");
				System.out.print("입력 >> ");
				int userNum = scan.nextInt();

				while (true) {
					if (userNum < 1 || userNum > 6) {
						System.out.println("1 ~ 6의 정수만 입력");
						userNum = scan.nextInt();
					} else {
						break;
					}
				}
				int comNum = rnd.nextInt(6) + 1;
				
				System.out.println("user : " + userNum);
				System.out.println("com : " + comNum);
				if(userNum > comNum) {
					System.out.println("user Win");
				} else if(userNum == comNum) {
					System.out.println("Draw");
				} else if(userNum < comNum) {
					System.out.println("user Lose");
				}
				
				System.out.println("===========================================");
			}

		}

	}

}
