package Number_2103;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 练习21
 * 
 * @author he
 *
 */

class A implements Runnable {
	public synchronized void run() {

		System.out.println("A 即将挂起 ");
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("A线程中断");
		}
		System.out.println("A 退出挂起");
	}
}

class B implements Runnable {
	A a;

	B(A a) {
		this.a = a;
	}

	public void run() {

		try {
			// a.c=true;
			TimeUnit.SECONDS.sleep(1);
			System.out.println("A 将被唤醒");
			synchronized (a) {
				a.notifyAll();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

public class P705 {
	public static void main(String[] args) throws Exception {
		ExecutorService eService = Executors.newCachedThreadPool();
		A a = new A();
		eService.execute(a);
		eService.execute(new B(a));
		TimeUnit.MILLISECONDS.sleep(100);
		eService.shutdown();
	}
}
