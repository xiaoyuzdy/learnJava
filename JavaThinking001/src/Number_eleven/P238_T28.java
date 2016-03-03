package Number_eleven;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * for语句的另一种用法
 * 
 * priorityqueue 里的值按自然顺序排序 及 数越小优先级越高 可通过自己的compartor进行修改
 * 
 * @author he
 * 
 */
public class P238_T28 {

	public static void print(PriorityQueue<?> priorityQueue) {

		for (Object date = priorityQueue.peek(); date != null; date = priorityQueue
				.poll()) {
			System.out.println(date + " ");
		}
		// 用while得到pritorityqueue里的值 与上面的for等价
		// while (priorityQueue.peek()!=null) {
		// System.out.println(priorityQueue.remove()+" ");
		// }

	}

	public static void main(String[] args) {

		PriorityQueue<Double> priorityQueue = new PriorityQueue<Double>();

		Random rand = new Random(47);

		for (int i = 0; i < 10; i++) {
			priorityQueue.offer(rand.nextDouble());
		}
		print(priorityQueue);

	}

}
