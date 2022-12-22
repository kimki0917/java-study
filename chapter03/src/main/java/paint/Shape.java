package paint;

public abstract class Shape implements Drawable{
	private String lineColor;
	private String fillColor;
	
	public abstract void draw();
	//맨 위에 abstract 지우면 에러난다
	
	public String getLineColor() {
		return lineColor;
	}
	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}
	public String getFillColor() {
		return fillColor;
	}
	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}
	
	
}
