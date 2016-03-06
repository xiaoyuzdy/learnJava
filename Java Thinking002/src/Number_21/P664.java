package Number_21;

import java.util.concurrent.TimeUnit;

/**
 * 如果一个线程是后台的那么它创建的子线程自动设置为后台线程
 * 
 * @author he
 *
 */

class Daemon implements Runnable {
	Thread t[] = new Thread[10];

	public void run() {
		for (int i = 0; i < t.length; i++) {
			// 创建子线程
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			System.out.println("DameonSpawn " + i + " started");
		}
		// 判断是不是后台线程
		for (int i = 0; i < t.length; i++) {
			System.out.println("t[" + i + "]" + "is Daemon" + t[i].isDaemon());
		}

		while (true) {
			Thread.yield();
		}
	}

}

class DaemonSpawn implements Runnable {
	public void run() {
		// TODO Auto-generated method stub
		Thread.yield();
	}
}

public class P664 {

	public static void main(String[] args) throws Exception {
		Thread tt = new Thread(new Daemon());
		// 设置为后台线程
		tt.setDaemon(true);
		tt.start();

		System.out.println("is Daemon ? " + tt.isDaemon());
		// 必须要有这句话，不然线程不运行 ，因为设置的是后台线程，而main是非后台线程，
		// 所以当main结束后JVM会自动关闭所有后台线程
//		TimeUnit.MILLISECONDS.sleep(1);
		// 休眠
		// tt.sleep(1);
	}

}
