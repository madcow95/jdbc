package com.bizpoll.javaex;

import java.util.Scanner;

public class Exercise4_11 {
	/*
	 * 1�� 1���� �����ϴ� �Ǻ���ġ������ 10��° ���� �������� ����ϴ� ���α׷� �Ǻ���ġ ���� : 
	 * ���� �� ���� ���ؼ� ���� ���� ����� ������ ����
	 * 
	 * ��) ���� �� ���� 1�� 1�̶�� �� �������� 2���ǰ� �� ���� ���� 1�� 2�� ���ؼ� 3
	 * 1, 1, 2, 3, 5, 8, 13, 21 ...
	 */

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("���° ����?");
		System.out.print("�Է� : ");
		int num = scan.nextInt();
		int[] numArray = new int[num];
		int i = 0;
		for (i = 0; i < numArray.length; i++) {
			numArray[i] = 1;
			if (i >= 2) {
				numArray[i] = numArray[i - 1] + numArray[i - 2];
			}
			System.out.println((i + 1) + "��° �Ǻ���ġ ���� �� : " + numArray[i]);
		}
		

	}
}
