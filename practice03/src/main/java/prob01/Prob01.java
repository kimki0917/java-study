package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		Scanner c = new Scanner(System.in);
		/* 코드 작성 */
		System.out.print("금액 : ");
		int x = c.nextInt();
		System.out.println(x);
		
		int cnt = x;
		for(int i=0;i<MONEYS.length;i++) {
			 
			cnt%=MONEYS[i];
			System.out.println(MONEYS[i]+" 원 : " + cnt/MONEYS[i] +" 개");
		}

		
		scanner.close();
 	}
}