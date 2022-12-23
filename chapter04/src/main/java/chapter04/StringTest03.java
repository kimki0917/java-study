package chapter04;

public class StringTest03 {
	public static void main(String[] args) {
		//String s1 = "Hello " + "World" + " Java " + 17;
		String s1 =  new StringBuffer("Hello ")
		.append("World")
		.append(" Java ")
		.append(17)
		.toString();
		
		String s2 = "";
		for(int i = 0; i < 1000000; i++) {
			// s2 = s2 + i;
			//s2 = new StringBuffer(s2).append(i).toString();
			//System.out.println(s2);
		}
		//컴퓨터는 메모리에 접근할때 cpu를 많이 쓴다
		StringBuffer sb = new StringBuffer("");
		
		for(int i = 0; i < 1000000; i++) {
			sb.append(i);
		}
		String s3 = sb.toString();
		
		//Sting method들 ....
		String s4 = "aBcABCabcAbc";
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("abc"));
		System.out.println(s4.indexOf("abc",7));
		System.out.println(s4.substring(3));
		System.out.println(s4.substring(3, 5));
		
		String s5 = "     ab     cd     ";
		String s6 = "efg,hij,klm,nop,qrs";
		
		String s7 = s5.concat(s6);
		System.out.println(s7);
		
		System.out.println("---"+s5.trim()+"---");
		System.out.println("---"+s5.replaceAll(" ","")+"---");
		
		String[] tokens = s6.split(",");
		for(String s : tokens) {
			System.out.println(s);
		}
		
		String[] tokens2 = s6.split(" ");
		//+ 연산을 반복회수가 많은 for문에서 사용하지 말 것
		//차라리 append를 사용할 것
		for(String s : tokens2) {
			System.out.println(s);
		}
		
		
	}
}
