package prob4;

public class SoundTest {

	public static void main(String[] args) {
		printSound( new Cat() );
		printSound( new Dog() );
		printSound( new Sparrow() );
		printSound( new Duck() );
		
		//인터페이스 각각 구현해볼것
	}
	
	private static void printSound( Soundable soundable ) {
		System.out.println( soundable.sound() );
	}
}