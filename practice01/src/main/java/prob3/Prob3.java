package prob3;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();

		int sum = 0;
		for (int i = 0; i <= input; i++) {
			if (i % 2 == 0 && input % 2 == 0 || i % 2 != 0 && input % 2 != 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
}
