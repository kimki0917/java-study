package prob5;

public class MyStack03<T> {
	private int top;
	private Object[] buffer;

	public MyStack03(int capacity) {
		top = -1;
		buffer = new Object[capacity];
	}

	public void push(String s) {
		if (top == buffer.length - 1) {
			resize();
		}

		buffer[++top] = s;		
	}

	public Object pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}

		Object result = buffer[top];
		buffer[top--] = null;

		return result;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	private void resize() {
		String[] temp = new String[buffer.length * 2];
		for (int i = 0; i <= top; i++) {
			temp[i] = (String) buffer[i];
		}

		buffer = temp;
	}
}