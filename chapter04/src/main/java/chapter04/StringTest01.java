package chapter04;

public class StringTest01 {

	public static void main(String[] args) {
		System.out.println("c:\temp");
		
		/// 실행시 결과값 
		/// c:		emp
		/// 저렇게 나오는 이유?
		// \t : tab
		// \r : carriage return
		// \n : new line
		// \b : bell - 출력을 소리로(제어문자)
		// \\ : \ - 역슬래시를 그대로 쓰고싶을 때 두개쓰면 된다
		
		//"HELLO"
		System.out.println("\"HELLO\"");
		///자바는 ""이 사이를 string 리터럴이라고 하는데
		///그냥 쓰면 식별자로 인식해서 에러가 난다
		/// 따라서 앞에 \를 추가해줘야한다
		
		System.out.print("hello\tworld\n");
		System.out.println("hello\tworld\n");
		
		//'
		char c = '\'';
		System.out.println(c);
		//System.out.print("1"+"\n");
		System.out.println("1");
		System.out.print("2");
		
	}

}
