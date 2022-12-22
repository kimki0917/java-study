package prob3;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		while (true) {
			System.out.print("수를 입력 하세요 : ");
			int number = scanner.nextInt();

			int cnt = number / 2;
			int sum = 0;
			if (number % 2 == 0) {
				for (int i = cnt; i > 0; i--) {
					sum = sum + i * 2;
				}
			} else {
				for (int i = cnt + 1; i > 0; i--) {
					sum = sum + ((i * 2) - 1);
				}
			}
			System.out.println(sum);
		}
	}
}
