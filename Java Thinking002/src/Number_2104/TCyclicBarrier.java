package Number_2104;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * P724 CyclicBarrier�����ڣ���ϣ������һ���������ǲ��е�ִ�й�����Ȼ���ڽ�����һ������֮ǰ�ȴ���֪������������ɡ�
 * 
 * @author he
 *
 */

class Horse implements Runnable {
	private static int count = 0;
	final int id = count++;
	private int strides = 0;// ��ǰ���Ĳ��� �����������
	private static Random random = new Random(47);
	private static CyclicBarrier barrier;

	public Horse(CyclicBarrier cBarrier) {
		barrier = cBarrier;
	}

	public synchronized int getStrides() {
		return strides;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					strides += random.nextInt(3);// ������Ӳ���
				}
				barrier.await();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "House " + id + " ";
	}

	public String tracks() {
		StringBuilder sb = new StringBuilder();
		// ��ӡ���ܵ�·��
		for (int i = 0; i < getStrides(); i++) {
			sb.append("*");
		}
		sb.append(id);
		return sb.toString();
	}

}

public class TCyclicBarrier {
	static final int FINISH_LINE = 75;
	private List<Horse> horses = new ArrayList<Horse>();
	private ExecutorService eService = Executors.newCachedThreadPool();
	private CyclicBarrier barrier;

	public TCyclicBarrier(int number, final int sleeptime) {
		barrier = new CyclicBarrier(number, new Runnable() {

			public void run() {
				StringBuilder s = new StringBuilder();
				// ��ӡ·�̳���
				for (int i = 0; i < FINISH_LINE; i++) {
					s.append("=");
				}
				System.out.println(s);
				// ��ӡÿ���̣߳�ÿƥ�����ܵĳ���
				for (Horse horse : horses) {
					System.out.println(horse.tracks());
				}
				// �����һƥ�����յ� �߳���ֹ
				for (Horse horse2 : horses) {

					if (horse2.getStrides() >= FINISH_LINE) {
						System.out.println("Win " + horse2.id);
						eService.shutdownNow();
						return;
					}
				}
				try {
					TimeUnit.MILLISECONDS.sleep(sleeptime);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});

		for (int i = 0; i < number; i++) {
			Horse horse = new Horse(barrier);
			horses.add(horse);
			eService.execute(horse);
		}

	}

	public static void main(String[] args) {
		int number = 7;//�߳���
		int sleeptime = 200;//����ʱ��
		new TCyclicBarrier(number, sleeptime);
	}

}
