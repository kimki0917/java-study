package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Random r = new Random();
		int k = r.nextInt(100) + 1;

		Scanner c = new Scanner(System.in);
		System.out.println("수를 결정하였습니다. 맞추어 보세요");
		int input = 0;
		int min = 1;
		int max = 100;
		int cnt = 0;
		
		while (k != input) {
			cnt++;
			System.out.println(min + " - " + max);
			System.out.print(cnt + ">>");
			input = c.nextInt();
			if (k > input) {
				System.out.println("더 높게");
				min = input;
			} else if (k < input) {
				System.out.println(" 더 낮게");
				max = input;
			} else if (k == input) {
				System.out.println("맞았습니다.");
				System.out.println("다시 하시겠습니까?");

				String answer = c.next();
				if (answer.equals("y")) {
					input =0;
					min=1;
					max=100;
					cnt=0;
					k = r.nextInt(100) + 1;
				}
			}
			
		}
	}

}