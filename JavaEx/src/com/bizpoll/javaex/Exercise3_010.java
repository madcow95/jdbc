package com.bizpoll.javaex;

public class Exercise3_010 {
	/*
	 * �빮�ڸ� �ҹ��ڷ� �����ϴ� �ڵ带 �ۼ� ��, ���� ch�� ����� ���ڰ� �빮���� ��쿡�� �ҹ��ڷ� ���� ��Ʈ : �����ڵ�� �ҹ��ڰ�
	 * �빮�ں��� 32��ŭ �� ŭ ex) ���� ch�� 'A'��� �빮�ڸ� �Է¹޾����� 'a'�� ���
	 */
	public static void main(String args[]) {

		char ch = 'A';
		int askiiCh = (int) ch + 32;
		if ((int) ch > 96) {
			askiiCh = (int) ch - 32;
		}
		System.out.println((char) askiiCh);
		
		
		char ch1 = 'B';
		char lowerCase = ('A' <= ch1 && ch1 <= 'Z') ? (char) (ch1 + 32) : ch1; 
		System.out.println("ch to lowerCase : " + lowerCase);

	}

}
