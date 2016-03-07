package Number_2103;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ��ϰ21
 * 
 * @author he
 *
 */

class A implements Runnable {
	public synchronized void run() {

		System.out.println("A �������� ");
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("A�߳��ж�");
		}
		System.out.println("A �˳�����");
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
			System.out.println("A ��������");
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
