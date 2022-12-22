package prob6;

public class RectTriangle extends Shape implements Resizable{

	private double width;
	private double height;
	
	public RectTriangle(double w, double h) {
		this.width=w;
		this.height=h;
	}

	@Override
	public void resize(double d) {
		
	}

	@Override
	public double getPerimeter() {
		return width + height +(Math.sqrt(width*width + height*height));
	}
	
	@Override
	public double getArea() {
		return width*height/2;
	}
}
