package prob6;

public class Rectangle extends Shape {

	private double width;
	private double height;

	public Rectangle(double w, double h) {
		this.width = w;
		this.height = h;
	}

	@Override
	public double getPerimeter() {
		return (width + height)*2;
	}
	
	@Override
	public double getArea() {
	
		return width*height;
	}

}
