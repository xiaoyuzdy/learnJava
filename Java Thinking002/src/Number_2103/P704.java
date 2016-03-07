package Number_2103;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程之间的协作
 * 
 * @author he
 *
 */

class Car {
	 private  volatile boolean waxOn = false;

	synchronized void waxed() {
		waxOn = true;
		notifyAll();// 唤醒监视器中所有的线程
	}

	synchronized void waitForWaxing() throws InterruptedException {
		while (waxOn == false) {
			wait();
		}
	}

	synchronized void buffed() {
		waxOn = false;
		notifyAll();
	}

	synchronized void waitForBuffing() throws InterruptedException {
		while (waxOn == true) {
			wait();
		}
	}

}

class WaxOn implements Runnable {
	private Car car;

	public WaxOn(Car c) {
		car = c;
	}

	public void run() {
		while (!Thread.interrupted()) {

			try {
				System.out.println("Wax On");
				TimeUnit.MILLISECONDS.sleep(100);
				car.waxed();
				car.waitForBuffing();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Exiting via interrupt");
			}

		}
		System.out.println("Ending wax on task");
	}
}

class WaxOff implements Runnable {
	private Car car;

	public WaxOff(Car c) {
		car = c;
	}

	public void run() {
		while (!Thread.interrupted()) {

			try {
				car.waitForWaxing();
				System.out.println("Wax Off");
				TimeUnit.MILLISECONDS.sleep(100);
				car.buffed();

			} catch (InterruptedException e) {
				System.out.println("Exiting Wax Off ");
			}
		}
		System.out.println("Ending Wax Off task");
	}
}

public class P704 {
	public static void main(String[] args) throws Exception {
		Car c = new Car();
		ExecutorService eService = Executors.newCachedThreadPool();
		eService.execute(new WaxOn(c));
		eService.execute(new WaxOff(c));
		TimeUnit.SECONDS.sleep(6);
		eService.shutdown();
	}
}
