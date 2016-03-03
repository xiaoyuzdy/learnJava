package Number_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程的优先级 优先级在run（）的开头部分设定
 */
public class P660 implements Runnable {
	private int countdown = 4;
	private volatile double d;// 防止被编译器优化
	private int priority;

	P660(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// 返回线程的引用
		return Thread.currentThread() + " : " + countdown;
	}

	public void run() {
		// 设置线程的优先级
		Thread.currentThread().setPriority(priority);
		while (true) {
			// for循环的目的是为了看到设置优先级的效果
			for (int i = 0; i < 100000; i++) {
				d += (Math.PI + Math.E) / (double) i;
				if (i % 1000 == 0) {
					Thread.yield();
				}
			}

			System.out.println(this);
			if (--countdown == 0) {
				return;
			}

		}

	}

	public static void main(String[] args) {
		ExecutorService eService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			eService.execute(new P660(Thread.MIN_PRIORITY));
		}
		// 优先级最高
		eService.execute(new P660(Thread.MAX_PRIORITY));
		eService.shutdown();
	}

}
