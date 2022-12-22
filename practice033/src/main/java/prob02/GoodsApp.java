package prob02;

import java.util.Scanner;

public class GoodsApp {
//	public final class GoodsApp {
// : extends  확장금지 여기서 끝내라는 뜻
	private static final int COUNT_GOODS = 3;
	public void m() {
		
	}
	//override 하지 말라는 뜻
	public static void main(String[] args) {
		
		//final int a = 10;
		//대입이 끝났다
		//a = 20이라는 줄을 생성하면 에러를 내겠다 는 뜻
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for(int i = 0; i<COUNT_GOODS; i++) {
			String info = scanner.nextLine();
			String[] infos =info.split(" ");
			//제약사항 : 정보 구분시 스페이스바
			System.out.println(infos[0]+":" + infos[1] + ":"+infos[2]);
		}

		// 상품 출력
		
		// 자원정리
		scanner.close();
	}
}
