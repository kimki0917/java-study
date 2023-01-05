package chapter04;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);

		printDate01(now);
		printDate02(now);

		byte[] data = new byte[9];
		try {
			String s = new String(data, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private static void printDate01(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(d);
		System.out.println(date);
	}

	private static void printDate02(Date d) {
		// 년도
		int year = d.getYear();
		int month = d.getMonth();
		int date = d.getDate();
		int hours = d.getHours();
		int minutes = d.getMinutes();
		int seconds = d.getSeconds();
		// 월
		// 일
		// 시
		// 분
		// 초
		System.out.println((year + 1900) + "-" + month + "-" + date + " " + hours + ":" + minutes + ":" + seconds);
	}
}
