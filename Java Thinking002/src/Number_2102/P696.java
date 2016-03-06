package Number_2102;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞和终端
 * 
 * @author he
 *
 */
// sleep()阻塞
class sleepBlocked implements Runnable {
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException");
		}
		System.out.println("Exiting SleepBlocked .run()");
	}
}

// I/O阻塞
class ioBlocked implements Runnable {
	private InputStream ip;

	ioBlocked(InputStream ip) {
		this.ip = ip;
	}

	public void run() {
		try {
			System.out.println("Waiting for read()");
			ip.read();
		} catch (IOException e) {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("线程被中断");
			} else {
				throw new RuntimeException();
			}

			System.out.println("Exiting IOBlocked.run()");

		}

	}

}

class SyncBlocked implements Runnable {

	public synchronized static void f() {
		while (true) {
			Thread.yield();
		}
	}

	public SyncBlocked() {
		new Thread() {
			public void run() {
				f(); // 因为外部的run不会终止 所以此方法永远不会执行

			};
		}.start();
	}

	public void run() {
		System.out.println("Try to call of f()");
		f();
		System.out.println("Exiting SycncBlocked.run()");
	}

}

public class P696 {
	protected static ExecutorService eService = Executors.newCachedThreadPool();

	static void test(Runnable r) throws Exception {
		Future<?> f = eService.submit(r);
		TimeUnit.MICROSECONDS.sleep(100);
		// 打印终止线程的名字
		System.out.println("Interrupt:" + r.getClass().getName());
		f.cancel(true);
		System.out.println("Interrupt sent to " + r.getClass().getName());

	}

	public static void main(String[] args) throws Exception {
		test(new sleepBlocked());
		test(new ioBlocked(System.in));
		test(new SyncBlocked());
		TimeUnit.MICROSECONDS.sleep(1000);
		System.out.println(" System.exit()");
		System.exit(0);

	}

}
