package com.bizpoll.javaex;

import java.util.Scanner;

public class K_Test {
	/*
	 * ����ڰ� ������ ���� �Է��ϸ�, �Էµ� ���� �� �ڸ����� �� 
	 * ex) ������ �� 12345�� �Է��� ��� ��� : 15 (1 + 2 + 3 + 4 + 5)
	 */

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("�Է� >> ");
		int userInput = scan.nextInt();
		int sum = 0;
		
		while (userInput > 0) {
			sum += userInput % 10;
			userInput /=  10;
		}
		System.out.println(sum);
		scan.close();
	}
}