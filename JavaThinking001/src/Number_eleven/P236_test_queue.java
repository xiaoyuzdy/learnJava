package Number_eleven;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Queue 的简单使用
 * 
 * @author he
 * 
 */

public class P236_test_queue {

	public static void printQ(Queue queue) {

		while (queue.peek() != null) {
			System.out.print(queue.poll() + " ");
		}
		System.out.println("\n");

	}

	public static void main(String[] args) {

		Queue<Integer> queue = new LinkedList<Integer>();
		Random rand = new Random(47);
		for (int i = 0; i < 10; i++) {

			Integer j = rand.nextInt(i + 10);

			queue.offer(j);

		}
		printQ(queue);
		Queue<Character> queue2 = new LinkedList<Character>();

		for (char c : "abcdefghik".toCharArray()) {

			queue2.offer(c);

		}

		printQ(queue2);

	}

}
