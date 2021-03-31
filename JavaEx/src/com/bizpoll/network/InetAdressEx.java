package com.bizpoll.network;

import java.net.InetAddress;
import java.util.Scanner;

public class InetAdressEx {

	Scanner scanner;

	public InetAdressEx() {
		System.out.println("Host �̸��� �Է��� �ּ���");
		scanner = new Scanner(System.in);

		try {
			// InetAddress inetAddress = InetAddress.getByName(scanner.next());
			InetAddress[] iaArr = InetAddress.getAllByName(scanner.next());

			System.out.println("�̸� : " + iaArr[0].getHostName());
			for (InetAddress inetAddress2 : iaArr) {
				System.out.println("Address : " + inetAddress2.getHostAddress());
			}
			// System.out.println("Address : " + inetAddress.getHostAddress());
		} catch (Exception e) {
			e.printStackTrace(); // print�� stack�϶� ó������ ������ trace�Ͽ� exception�� ���´�
			System.out.println(e.getMessage());
		}
	}
}
