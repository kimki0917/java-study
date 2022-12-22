package prob04;

public class Depart extends Employee {
	
	private String department;
	public Depart(String string, int i, String department) {
		super(string,i);
		this.department = "기획부";
	}

	@Override
	public void getInformation() {
		System.out.println( "이름:" + this.getName() + "연봉:" + this.getSalary() +"부서 : "+ department);
	}
}
