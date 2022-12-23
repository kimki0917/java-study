package chapter04;

public class Object03Test {

	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = new String("hello");
	
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode() + ":"+ s2.hashCode());
		System.out.println(System.identityHashCode(s1) + ":"+ System.identityHashCode(s2));

		System.out.println("========================================================");

		String s3 = "hello";
		String s4 = "hello";
		
		///concontrate
		///String은 불변이어야한다
		///Hello hello가 두번쓰이다가 하나가 변경됐을 때,
		///변경되지 않은 나머지 하나의 값이 바뀌지 않아야 하기 때문
		
		///new String 보다 concentrate(리터럴!)를 쓰는게 좋다
		///리터럴이 쓰고 지우는게 용이하기 때문
		
		///Integer 도 불변,  long도 마찬가지
		
		///concentrate는 JVM이 관리해줌
		
		/// String s3 = "hello" + " " + "World"; 가 어떻게 가능한가?
		/// c++은 연산자 오버로드가 있기 때문에 가능하다
		/// 그렇다면 자바에서 저게 가능한 이유는 무엇인가?
		
		
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		System.out.println(s3.hashCode() + ":"+ s4.hashCode());
		System.out.println(System.identityHashCode(s3) + ":"+ System.identityHashCode(s4));

		//		String ss1 = "hello";
//		String ss2 = new  String("hello");
//		
//		System.out.println(ss1 == ss2);
//		System.out.println(ss1.equals(ss2));

		
//		String s11 = "hello";
//		String s22 = "hello";
//
//		System.out.println(s11 == s22);
//		System.out.println(s11.equals(s22));

	}

}
