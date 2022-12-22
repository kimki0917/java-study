package chapter03;

public class Goods {
	public static int countOfGoods = 0;
	private String name;
	private int price;
	private int countStock;
	private int countSold;

	public Goods() {
		// Goods.countOfGoods = Goods.countOfGoods + 1; 같은 클래스에서는 Goods. 를 생략할 수 있다.
		Goods.countOfGoods = Goods.countOfGoods + 1;
	}
	
	public Goods(String name, int price, int countStock, int countSold) {
		this.name =name;
		this.price= price;
		this.countStock = countStock;
		this.countSold = countSold;
	}
	
	public int calcDiscountPrice(float discountRate) {
		int i = (int) 4.5;
		float f = 3;
		return (int)(price*discountRate);
	}

	public void printInfo() {
		System.out.println(name + ":" + price + ":" + countStock + ":" + countSold);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		if (price < 0) {
			price = 0;
		}
	}

	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	public int getCountSold() {
		return countSold;
	}

	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

}
