package prob5;

public class MyStack {
	private String[] buffer;
	private int cnt;
	private String[] newBuffer;

	public MyStack(int i) {
		this.buffer = new String[i];
		this.cnt =0;
		// TODO Auto-generated constructor stub
	}

	public void push(String string) {

		if (cnt <buffer.length) {
				buffer[cnt]=string;
				
				
		}else if(cnt>=buffer.length){
			
			newBuffer = new String[buffer.length+1];
			
			for(int i =0;i<buffer.length;i++) {
				newBuffer[i]=buffer[i];
			}
			newBuffer[buffer.length]=string;
			buffer = newBuffer;
		}
		cnt ++;
	}

	public String pop() throws MyStackException {
		cnt --;
		
		if(cnt>=0) {
			return buffer[cnt];
		}else {
			throw new MyStackException("Stack is empty");
		}
		
	}

	public boolean isEmpty() throws MyStackException {
		if(cnt>0) {
			return false;
		}else {
			return true;
		}
	}

}