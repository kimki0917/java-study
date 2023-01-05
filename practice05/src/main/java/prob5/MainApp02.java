package prob5;

public class MainApp02 {
//stack 만드는 문제
	// 자료구조
	// 새 배열을 만들어서
	//배열을 다 만든 다음에
	//buffer를 가리키게
	//메소드를 만들어서
	//다음에도 쓸 수 있게
	
	//empty
	//배열크기가지고 따지면 안됨
	//index가 0이나 마이너스 될 때까지
	
	public static void main(String[] args) {
		try {
			MyStack02 stack = new MyStack02(3);
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			stack.push(".");

			while (stack.isEmpty() == false) {
				String s = stack.pop();
				System.out.println(s);
			}

			System.out.println("======================================");

			stack = new MyStack02(3);
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());

		} catch (MyStackException ex) {
			System.out.println(ex);
		}

	}

}
