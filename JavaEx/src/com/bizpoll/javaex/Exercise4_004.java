package com.bizpoll.javaex;

public class Exercise4_004 {
	/*
	 * 1 + (-2) + 3 + (-4)+ ...�� ���� ������ ��� ���س����� �� ����� ���ؾ� ������ 100 �̻��� �Ǵ���
	 */
	public static void main(String args[]) {
		int i = 0;
		int sum = 0;
		for (i = 0; sum < 100; i++) {
			int i2 = (i + 1);
			if (i2 % 2 == 0) {
				i2 *= -1;
			}
			sum += i2;
		}
		System.out.println(i + "����");
		System.out.println("sum = " + sum);
	}
}
