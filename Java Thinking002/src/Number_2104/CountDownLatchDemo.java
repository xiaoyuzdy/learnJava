package Number_2104;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * CountDownLatch һ��ͬ�������࣬�����һ�����������߳���ִ�еĲ���֮ǰ��������һ�������߳�һֱ�ȴ���
 * �κ�����������ϵ���wait()�ķ��������ܵ�������ֱ���������ֵ�ﵽ0�� ����ֵ���ܱ�����
 * 
 * @author he
 *
 */
class TaskPortion implements Runnable {
	private static int count = 0;
	private final int id = count++;
	private static Random random = new Random(47);
	private final CountDownLatch latch;

	public TaskPortion(CountDownLatch latch) {
		this.latch = latch;
	}

	/**
	 * ģ��������Ҫ��ʱ��
	 */
	public void doWork() {
		try {
			TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
			System.out.println("���� " + this + " ���");
		} catch (Exception e) {
		}
	}

	public void run() {
		doWork();
		latch.countDown();// ���һ���������������1

	}

	@Override
	public String toString() {
		return String.format("%1$-3d ", id);
	}

}

class waitTask implements Runnable {
	private static int count = 0;
	private final int id = count++;
	private final CountDownLatch latch;

	public waitTask(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			latch.await(); // ʹ��ǰ�߳�������������������֮ǰһֱ�ȴ��������̱߳��жϡ�
						  //�����ǰ����Ϊ�㣬��˷����������ء�
			System.out.println("Latch brrier passed for " + this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return String.format("WaitingTask %1$-3d ", id);
	}
}

public class CountDownLatchDemo {
	private static final int SIZE = 100;

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(SIZE);
		ExecutorService eService = Executors.newCachedThreadPool();

		for (int i = 0; i < 10; i++) {
			eService.execute(new waitTask(latch));
		}
		for (int i = 0; i < SIZE; i++) {
			eService.execute(new TaskPortion(latch));
		}

		eService.shutdown();

	}

}
/**
 * ��Ȼ�ȵ��õ��� waitTask��run������ָ��await(). ����CountDownLatch�ļ�������Ϊ0 �������� ����� ���� xx
 * ��ɣ�ȫ��ִ���꣩ Latch brrier passed for WaitingTask x
 * 
 */
