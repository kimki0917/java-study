package prob04;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		// TODO Auto-generated method stub
		String result = "";
		for(int i =0; i<strArr.length;i++) {
			result=result+strArr[i];
		}
		return result;
	}
}
