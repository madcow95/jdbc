package com.bizpoll.network;

import java.net.InetAddress;
import java.util.Scanner;

public class InetAdressEx {

	Scanner scanner;

	public InetAdressEx() {
		System.out.println("Host 이름을 입력해 주세요");
		scanner = new Scanner(System.in);

		try {
			// InetAddress inetAddress = InetAddress.getByName(scanner.next());
			InetAddress[] iaArr = InetAddress.getAllByName(scanner.next());

			System.out.println("이름 : " + iaArr[0].getHostName());
			for (InetAddress inetAddress2 : iaArr) {
				System.out.println("Address : " + inetAddress2.getHostAddress());
			}
			// System.out.println("Address : " + inetAddress.getHostAddress());
		} catch (Exception e) {
			e.printStackTrace(); // print가 stack일때 처음나온 에러로 trace하여 exception을 막는다
			System.out.println(e.getMessage());
		}
	}
}
