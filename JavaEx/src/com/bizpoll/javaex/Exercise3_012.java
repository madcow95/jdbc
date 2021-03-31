package com.bizpoll.javaex;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Exercise3_012 {
	/*
	 * �䱸 ���� 1. �Է°��� ���ڿ��� ���(�޴� ���ý�) �޴� : 1�� �Է½� ���ӽ��� 2�� �Է½� ��������(System.exit(0)��
	 * �̿��Ұ�) 2. �����ϰڴٴ� �ǹ��� ���ڸ� �Է����� ������ ���� �޴��� ��� ǥ�� 3. �ֻ��� ������ ���� ����ڷκ��� 1 ~ 6������
	 * ���� ��� (��ȿ�� üũ �� ���� ���� ���Ǹ� ��� �ݺ��ؼ� �Է°� üũ 4. ��ǻ�ʹ� �����ϰ� ���ڸ� ���(1 ~ 6)
	 */

	public static void main(String args[]) {
		Random rnd = new Random();
		Scanner scan = new Scanner(System.in);
		while (true) {
			int comDice = rnd.nextInt(6) + 1;
			System.out.println("���ӽ��� : 1 / �������� : 2");
			System.out.print("�Է� >> ");
			
			while(true) {
				try {
					String strSelect = scan.nextLine();
					int select = Integer.valueOf(strSelect);
					if (select >= 1 && select <= 2) {
						if (select == 1) {
							System.out.println("���� �Է� (1 ~ 6)");
							System.out.print("�Է� >> ");
							String strDice = scan.nextLine();
							int dice = Integer.valueOf(strDice);
							
							System.out.println("user : " + dice);
							System.out.println("com : " + comDice);
							if (dice >= 1 && dice <= 6) {
								if (dice > comDice) {
									System.out.println("user �¸�");
								} else if (dice == comDice) {
									System.out.println("���º�");
								} else if (dice < comDice) {
									System.out.println("com �¸�");
								}
								break;
							} else {
								System.out.println("dice�� 1 ~ 6�� �Է����ּ���");
								break;
							}

						} else if (select == 2) {
							System.out.println("��������");
							break;
						}
					} else {
						System.out.println("1 ~ 2�� �Է��ϼ���");
						System.out.print("���Է� >> ");
					}
				} catch (Exception e) {
					System.out.println("���ڸ� �Է����ּ���");
					break;
				}
			}break;
			

		}

	}
}
