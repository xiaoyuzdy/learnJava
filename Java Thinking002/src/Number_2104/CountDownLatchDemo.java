package Number_2104;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * CountDownLatch 一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
 * 任何在这个对象上调用wait()的方法都将受到阻塞，直到这个计数值达到0， 计数值不能被重置
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
	 * 模拟任务需要的时间
	 */
	public void doWork() {
		try {
			TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
			System.out.println("任务 " + this + " 完成");
		} catch (Exception e) {
		}
	}

	public void run() {
		doWork();
		latch.countDown();// 完成一个任务则计数器减1

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
			latch.await(); // 使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断。
						  //如果当前计数为零，则此方法立即返回。
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
 * 虽然先调用的是 waitTask，run方法中指向await(). 由于CountDownLatch的计数器不为0 所以阻塞 结果： 任务 xx
 * 完成（全部执行完） Latch brrier passed for WaitingTask x
 * 
 */
