package Number_2104;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch 一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
 * 任何在这个对象上调用wait()的方法都将受到阻塞，知道这个计数值达到0， 计数值不能被重置
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
		latch.countDown();// 计数器减1

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
			latch.await(); // 如果计数器不为0阻塞
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
 * 虽然先调用的是 waitTask，run方法中指向await(). 由于CountDownLatch的计数器不为0 所以阻塞
 * 
 */
