package Number_eleven;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * for������һ���÷�
 * 
 * priorityqueue ���ֵ����Ȼ˳������ �� ��ԽС���ȼ�Խ�� ��ͨ���Լ���compartor�����޸�
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
		// ��while�õ�pritorityqueue���ֵ �������for�ȼ�
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
