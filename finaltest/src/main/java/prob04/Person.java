package prob04;

public class Person {
	
	private static int numberOfPerson;
	private int age;
	private String name;

	public Person() {
		this(12,"");
	}

	public Person(String string) {
		this(12,string);
	}

	public Person(int i, String string) {
		this.age = i;
		this.name = string;
		numberOfPerson++;
	}

	public static int getPopulation() {
		
		return numberOfPerson;
	}

	public void selfIntroduce() {
		System.out.println("내 이름은"+this.name+"이며, 나이는"+this.age+"살입니다.");
	}

	/* 코드 작성 */
}
