package Number_2104;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch һ��ͬ�������࣬�����һ�����������߳���ִ�еĲ���֮ǰ��������һ�������߳�һֱ�ȴ���
 * �κ�����������ϵ���wait()�ķ��������ܵ�������֪���������ֵ�ﵽ0�� ����ֵ���ܱ�����
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


	public void doWork() {
		try {
			TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
			System.out.println(this + "completed");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void run() {
		doWork();
		latch.countDown();// ��������1

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
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
			latch.await(); // �����������Ϊ0����
			System.out.println("Latch brrier passed for " + this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {

		return String.format("WaitingTask %1$-3d ", id);
	}

}

public class P723 {
	private static final int SIZE = 20;

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
 * ��Ȼ�ȵ��õ��� waitTask��run������ָ��await(). ����CountDownLatch�ļ�������Ϊ0 ��������
 * 
 */
