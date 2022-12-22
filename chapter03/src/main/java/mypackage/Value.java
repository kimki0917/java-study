package mypackage;

public class Value {

	public static void main(String[] args) {
		Value a = new Value(10);
		Value b = new Value(20);
		System.out.println("a:" + a.val + " , b:" + b.val);
		swap(a, b);
		
		System.out.println("a:" + a.val + " , b:" + b.val);
		}

	private static void swap(Value m, Value n) {
		// TODO Auto-generated method stub
		int temp = m.val;
		m.val=n.val;
		n.val=temp;
	}

	public Value(int val) {
		this.val = val;
	}

	public int val;
}
