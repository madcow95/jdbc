package com.bizpoll.javaex;

public class Exercise4_006 {
	/*
	 *  �ΰ��� �ֻ����� ������ ��, ���� ���� 6�� �Ǵ� ��� ����� ���� ����ϴ� ���α׷�
	 *  [���] 1 + 5 = 6 / 2 + 4 = 6 / 3 + 3 = 6 / 4 + 2 = 6 / 5 + 1 = 6
	 */
	public static void main(String[] args) {
		int sum = 0;
		int i = 0;
		int j = 0;
		for (i = 1; i < 6; i++) {
			for (j = 1; j < 6; j++) {
				sum = i + j;
				if(sum == 6) {
					System.out.println(i + " + " + j + " = " + sum);
				}
			}
			
		}
	}
}
