package Number_2102;
/**
 * 防止任务在共享资源上产生冲突的第二种方式是根除对变量的共享
 * 本地线程储存时一种自动化机制，可以为使用相同变量的每个不同的线程都创建不同的储存
 */

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Access implements Runnable {

	final int id;

	public Access(int id) {
		this.id = id;
	}

	public void run() {
		// 如果线程不被终止
		while (!Thread.currentThread().isInterrupted()) {
			P691.increment();
			System.out.println(this);
			Thread.yield();
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " #" +id+" id:"+ P691.get();
	}

}

public class P691 {

	private static ThreadLocal<Integer> tLocal = new ThreadLocal<Integer>() {
		// 匿名内部类
		private Random rand = new Random(47);

		// 返回当前初始值
		protected synchronized Integer initialValue() {
			return rand.nextInt(10000);
		}
	};

	//// threadLocal 保证了不会出现竞争条件所以 increment和get不用进行同步化进程控制
	// 设置值
	public static void increment() {
		tLocal.set(get() + 1);
	}

	public static int get() {
		return tLocal.get();
	}

	public static void main(String[] args) throws Exception {
		ExecutorService eService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			eService.execute(new Access(i));
		}
		TimeUnit.SECONDS.sleep(3);;
		eService.shutdown();
	}
}
