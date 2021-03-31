package com.bizpoll.network;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLConEx {
	// ���������� �ҽ��� �ҷ�����
	public URLConEx() {
		Scanner scan = new Scanner(System.in);
		String code = null;

		System.out.print("�� �ּҸ� �Է��ϼ��� : ");
		String address = scan.next(); // � ������ ���� ��� �� ���� �̿��ؼ� �ϴ°� ������

		try {
			URL url = new URL(address); // �Է°� address�� url
			URLConnection con = url.openConnection();

			BufferedReader webData = new BufferedReader(new InputStreamReader(con.getInputStream()));
			FileWriter fw = new FileWriter("D:\\java\\io\\file.html"); // �������� 2���� ���� : �ƽ�Ű �ڵ带 ��ǻ�Ͱ� ���ؽ�Ű����? \�� ���ؽ�Ű�� ���� \�� �ϳ� �� ����.
			
			// �ҷ����� ������ ���� �𸣱� ������ while
			// webData�� �������� ���� ���پ� �����ͼ� code������ �����ϰ� null�̸� �ݺ��� �����
			while ((code = webData.readLine()) != null) {
				fw.write(code); // fw�� ������ ��ġ FileWriter("")�� ���پ� ����־��
			}
			System.out.println("The End");
			fw.close();
			webData.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
