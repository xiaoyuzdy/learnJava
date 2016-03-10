package Number_2103;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用显示的Lock和Condition对象 重写 Wax、Buff
 * 
 * @author he
 *
 */

class Car3 {
	private boolean b = false;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void Wax3() {
		lock.lock();

		try {
			b = true;
			condition.signalAll();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			lock.unlock();
		}

	}

	public void Buff3() {
		lock.lock();
		try {
			b = false;
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void waitWax() throws InterruptedException {
		lock.lock();
		try {
			while (b == false) {
				condition.await();
			}

		} finally {
			lock.unlock();
		}
	}

	public void waitBuff() throws InterruptedException {
		lock.lock();
		try {
			while (b == true) {
				condition.await();
			}
		} finally {
			lock.unlock();
		}
	}

}

class Wax3 implements Runnable {
	private Car3 car3;

	public Wax3(Car3 car3) {
		this.car3 = car3;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println("Wax on");
				car3.Wax3();
				car3.waitBuff();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}

class Buff3 implements Runnable {
	private Car3 car3;

	public Buff3(Car3 car3) {
		this.car3 = car3;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				car3.waitWax();
				System.out.println("Wax Off");
				car3.Buff3();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("终止");
	}

}

public class P112 {
	public static void main(String[] args) throws Exception {
		Car3 car3 = new Car3();
		ExecutorService eService = Executors.newCachedThreadPool();
		eService.execute(new Wax3(car3));
		eService.execute(new Buff3(car3));
		TimeUnit.SECONDS.sleep(4);
		eService.shutdownNow();

	}

}
