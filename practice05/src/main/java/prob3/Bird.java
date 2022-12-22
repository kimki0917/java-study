package prob3;

public abstract class Bird {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//fly, sing 둘 다 추상

	protected abstract void fly();

	protected abstract void sing();
	
}