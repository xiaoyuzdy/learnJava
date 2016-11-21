package Number_2103;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * 死锁的经典问题，哲学家就餐问题
 * @author he
 *
 */
/**
 * 筷子类
 * 
 * @author he
 *
 */
class Chopstick {
	private boolean taken = false;

	// 如果被筷子占用则挂起线程
	public synchronized void take() throws InterruptedException {
		while (taken)
			wait();
		taken = true;
	}

	// 释放筷子，唤醒线程
	public synchronized void drop() throws InterruptedException {
		taken = false;
		notifyAll();
	}

}

class Philosopher implements Runnable {

	private Chopstick left;
	private Chopstick right;
	private final int id;
	private final int ponderFactor;// 模拟思考需要时间的时间因子，用于产生不同范围的随机时间
	private Random random = new Random(47);

	// 该方法用于模拟哲学家思考的时间、吃面的时间
	private void pause() throws InterruptedException {
		if (ponderFactor == 0)
			return;
		TimeUnit.MILLISECONDS.sleep(random.nextInt(ponderFactor * 300));
	}

	public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
		this.left = left;
		this.right = right;
		this.id = id;
		this.ponderFactor = ponderFactor;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println(this + " " + "thinking");
				pause();
				System.out.println(this + " 获取右边的筷子");
				right.take();
				System.out.println(this + " 获取左边的筷子");
				left.take();
				System.out.println(this + " 正在吃面");
				pause();
				right.drop();
				left.drop();
			}

		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

	@Override
	public String toString() {

		return "Philosopher  " + id;
	}

}



public class P722 {
	public static void main(String[] args) throws Exception {
		int size = 7;
		int ponder = 0;// 设置为0用于尽快的产生死锁

		ExecutorService service = Executors.newCachedThreadPool();
		Chopstick chopstick[] = new Chopstick[size];
		for (int i = 0; i < size; i++)
			chopstick[i] = new Chopstick();

		/**
		 * 因为每个哲学家都是先拿右边的筷子，所以可能会发生每个人都拿着右边的筷子并等待左边的筷子导致死锁的发生
		 */
		for (int i = 0; i < size; i++)
			service.execute(new Philosopher(chopstick[i], chopstick[(i + 1) % size], i, ponder));

		/**
		 * 如果最后一个人先拿左边的筷子后拿右边的筷子则可以避免死锁的发生（破环了循环等待条件）
		 */
//		for (int i = 0; i < size; i++) {
//			if (i < size - 1)
//				service.execute(new Philosopher(chopstick[i], chopstick[i + 1], i, ponder));
//			else
//				service.execute(new Philosopher(chopstick[0], chopstick[(i) % size], i, ponder));
//		}

		service.shutdown();

	}

}
