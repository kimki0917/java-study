package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Gugudan {
	private int resultNumber;
	private int COUNT_ANSWER_NUMBER;

	public Gugudan(int resultNumber, int COUNT_ANSWER_NUMBER) {
		this.resultNumber = resultNumber;
		this.COUNT_ANSWER_NUMBER = COUNT_ANSWER_NUMBER;
	}

	public int[] getList(int start, int end) {

		Set<Integer> set = new HashSet<Integer>();
		set.add(resultNumber);

		int random = 0;
		int random2 = 0;

		while (set.size() <= 9) {
			random = (int) (Math.random() * 9) + 1;
			random2 = (int) (Math.random() * 9) + 1;
			set.add(random*random2);
		}
		set.remove(resultNumber);
		int[] p = set.stream().mapToInt(Integer::intValue).toArray();
		return p;
	}
}
