package chapter04;

public class WrapperClassTest02 {
	public static void main(String[] args) {
		String s = "123456";
		int i = Integer.parseInt(s);

		String s1 = String.valueOf(i);
		String s2 = "" + i;
		System.out.println(s + ":" + s1 + ":" + s2);
		
		char c ='A';
		int a = Character.getNumericValue('A');
		System.out.println(a);
		System.out.println((int)c);
		
		String s4 = Integer.toBinaryString(15);
		System.out.println(s4);
		
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
		
	}
}
