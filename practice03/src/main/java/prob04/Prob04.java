package prob04;

public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray(c1);

		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}

	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		char[] result = str.toCharArray();

		for(int i = 0;i<str.length();i++) {
			result[i]=(char) str.charAt(str.length()-i-1);
		}
		return result;
	}

	public static void printCharArray(char[] array) {
		System.out.println(array);
	}
}