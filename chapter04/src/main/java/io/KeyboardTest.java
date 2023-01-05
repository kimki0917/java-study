package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {

			File file = new File("phone.txt");
			// 1. 기반 스트림(FileInputStream)
			FileInputStream fis = new FileInputStream(file);

			// 2. 보조스트림1(byte|byte|byte -> char)
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");

			// 3. 보조스트림2(char1|char2|char3|char4|\n -> "char1char2char3char4")
			br = new BufferedReader(isr);
			
			// 4.처리
			String line = null;
			while((line = br.readLine())!=null) {
				
			}
		} catch (IOException ex) {
			System.out.println("Error:" + ex);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				System.out.println("Error:" + ex);
			}
		}

	}
}
