package com.bizpoll.javaex;

public class Exercise3_002 {

	public static void main(String args[]) {
		// ����� ���� 123���̰� �ϳ��� �ٱ��Ͽ��� 10���� ����� �������ִٸ�
		// ��� �ٱ��ϰ� �ʿ����� �ۼ�.

		int apple = 123;
//		int basket = apple / 10;
		int basket = 10;
		int basketNum = apple / basket;
//		boolean bYes = apple % 10 == 0;
		boolean bYes = apple % basket == 0;
		int count = 0;
		for (int i = 0; i < basketNum; i++) {
			count++;
		}
		if(!bYes) {
			count = count + 1;
		}
		System.out.println("�ٱ��� ���� : " + count + "��");
		
		System.out.println("--------------------");
		
		int numOfApple = 123;
		int sizeOfBucket = 10;
		
		int numOfBucket = numOfApple / sizeOfBucket + (numOfApple % sizeOfBucket > 0 ? 1 : 0); // numOfApple�� sizeOfBucket�� �������� �������� 0���� ũ�� 1�� ���ϰ� �ƴϸ� 0�� ���ض�
		System.out.println("�ʿ��� �ٱ����� �� : " + numOfBucket + "��"); // �ʿ��� ���� ���Դٰ� �ٷ� ����������, �ٸ��ɷε� �׽�Ʈ �غ���
	}

}