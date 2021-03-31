package com.bizpoll.network;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLConEx {
	// 웹페이지의 소스를 불러오기
	public URLConEx() {
		Scanner scan = new Scanner(System.in);
		String code = null;

		System.out.print("웹 주소를 입력하세요 : ");
		String address = scan.next(); // 어떤 변수에 값을 담고 그 값을 이용해서 하는게 안정적

		try {
			URL url = new URL(address); // 입력값 address를 url
			URLConnection con = url.openConnection();

			BufferedReader webData = new BufferedReader(new InputStreamReader(con.getInputStream()));
			FileWriter fw = new FileWriter("D:\\java\\io\\file.html"); // 역슬래시 2개인 이유 : 아스키 코드를 컴퓨터가 이해시키려고? \를 이해시키기 위해 \를 하나 더 쓴다.
			
			// 불러오는 파일의 양을 모르기 때문에 while
			// webData에 가져오는 값을 한줄씩 가져와서 code변수에 저장하고 null이면 반복을 멈춰라
			while ((code = webData.readLine()) != null) {
				fw.write(code); // fw가 지정된 위치 FileWriter("")에 한줄씩 집어넣어라
			}
			System.out.println("The End");
			fw.close();
			webData.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
