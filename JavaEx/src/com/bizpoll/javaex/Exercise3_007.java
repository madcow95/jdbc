package com.bizpoll.javaex;

import java.util.Scanner;

public class Exercise3_007 {
	// Ű����κ��� �Է¹��� ������ ���� ch�� ������(�빮�� or �ҹ���)
	// �̰ų� ������ ���� ���� result�� ���� true�� �ǵ��� �ϴ� �ڵ�
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		System.out.print("�Է� >> ");
		char ch = scan.nextLine().charAt(0); // .charAt : �Է��� ���� 0��° ���� ���
		
		scan.close();
		
		boolean result = ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z') || ('0' <= ch && ch <= '9');
		System.out.println(ch);
		System.out.println(result);
		
	}
	
}
