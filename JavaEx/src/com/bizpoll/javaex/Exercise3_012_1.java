package com.bizpoll.javaex;

import java.util.Random;
import java.util.Scanner;

public class Exercise3_012_1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random rnd = new Random();

		while (true) {
			System.out.println("���ӽ��� : 1 / �������� : 2");
			System.out.print("�Է� >> ");
			int selItem = scan.nextInt();
			if (String.valueOf(selItem).equals("2")) { // "2".equals(String.valueOf(selItem));�� �ص��ȴ� ���ڿ��� null���� ������ �ȵǱ� ������ ���ڷ� �̷���� ���ڿ��ϰ�� �̷����ϴ°� ���� �������̴�.
				System.out.println("���� ����");
				System.exit(0);
			} else if (String.valueOf(selItem).equals("1")) {
				System.out.println("���� ����");
				System.out.println("�ֻ��� ����");
				System.out.println("1 ~ 6�� ������ �Է�");
				System.out.print("�Է� >> ");
				int userNum = scan.nextInt();

				while (true) {
					if (userNum < 1 || userNum > 6) {
						System.out.println("1 ~ 6�� ������ �Է�");
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
