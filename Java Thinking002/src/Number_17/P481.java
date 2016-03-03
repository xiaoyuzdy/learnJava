package Number_17;

import java.util.PriorityQueue;

/**
 * 优先级队列
 */

class DoList extends PriorityQueue<DoList.DoItem> {
	static class DoItem implements Comparable<DoItem> {
		private char primary;
		private int number;
		private String str;

		public DoItem(char pri, int num, String string) {
			primary = pri;
			number = num;
			str = string;
		}

		public int compareTo(DoItem o) {
			if (primary > o.primary) {
				return +1;
			}
			if (primary == o.primary) {
				if (number > o.number) {
					return +1;
				} else if (number == o.number) {
					return 0;
				}
			}

			return -1;

		}

		@Override
		public String toString() {
			return Character.toString(primary) + " " + number + ":" + str;
		}

	}

	public void add(char pri, int num, String string) {
		super.add(new DoItem(pri, num, string));
	}

}

public class P481 {
	public static void main(String[] args) {
		DoList li = new DoList();
		li.add('A', 1, "abc");
		li.add('A', 2, "abc");
		li.add('B', 2, "bcd");
		
		while(!li.isEmpty()){
			System.out.println(li.remove());
		}
	}
}
