package prob2;

public class Prob2 {
	public static void main(String[] args) {
		/* 코드 작성 */
		for (int x = 1; x < 10; x++) {
			for (int y = x; y < x + 10; y++) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
	}
}
