package com.bizpoll.javaex;

public class Exercise4_004_1 {
	
	public static void main(String[] args) {
		// �ʱ�ȭ�� �� ��Ű��
		int sum = 0;
		int s = 1;
		int num = 0;
		//     �ʱ�ȭ ���ǽ� ������ ��
		for (int i = 1; true; i++, s = -s) { // ���ǽĿ� true : ���� �ݺ�
			num = s * i;
			sum += num;
			
			if(sum >= 100) {
				break;
			}
		}
		System.out.println("num = " + num);
		System.out.println("sum = " + sum);
	}

}
