package prob1;

public class Sort {
	
	public static void main(String[] arg) {
	
		//버블소트 사용해보기
		//소트중에 버블소트가 제일 안좋음
		int array[] = { 5, 9, 3, 8, 60, 20, 1 };
		int count =  array.length;
		
		System.out.println( "Before sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print( array[ i ] + " " );
		}
		
		int cnt=0;
		
		for (int x=1; x<array.length;x++) {
			for(int y=0;y<array.length-x;y++) {
				if(array[y]>array[y+1]) {
					cnt=array[y];
					array[y]=array[y+1];
					array[y+1]=cnt;
					}	
			}
		}
		//
		// 정렬 알고리즘이 적용된 코드를 여기에 작성합니다.
		//

		
		// 결과 출력
		System.out.println( "\nAfter Sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}		
	}
}