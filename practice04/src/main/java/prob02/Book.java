package prob02;

public class Book {
	int bookNo;
	private String title;
	private String author;
	private int stateCode;

	public Book(int bookNo, String title, String author) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.stateCode = 1;
	}

	public void rent() {
		this.stateCode = 0;
		System.out.println(title + "이(가) 대여 됐습니다.");
	}

	public void print() {
		System.out.println("책 제목 : " + title + " , 작가  : " + author + " , 대여 유뮤 : "+(stateCode==1 ? "재고있음" : "대여중"));
		
	}

}
