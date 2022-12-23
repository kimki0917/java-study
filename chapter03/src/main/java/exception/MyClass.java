package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException, MyException{
		System.out.println("some code1....");
		System.out.println("some code2....");

		if (3 - 3 == 0) {
			throw new MyException();
		}
		if (5 - 5 == 0)
			throw new IOException();

		System.out.println("some code3....");
		System.out.println("some code4....");

		// throw new IOException 이후로는 코드가 실행이 되지않는다
		// try catch문으로 넘어가기때문에
		// 이후 코드가 실행이 되지 않는다고 에러가 뜸

	}
}
