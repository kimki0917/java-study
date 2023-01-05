package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			String test = String.valueOf(i);
			System.out.print(i);
			for(int y=0;y<test.length();y++) {
				char c = test.charAt(y);
				if(c=='3'||c=='6'||c=='9')
				System.out.print("짝");
			}
			System.out.println();
		}
	}
}
