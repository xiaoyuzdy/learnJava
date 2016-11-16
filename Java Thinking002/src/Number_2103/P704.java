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
	private boolean waxOn = false;

	synchronized void waxed() {
		waxOn = true;
		notifyAll();// 唤醒监视器中所有的线程
	}

	synchronized void waitForWaxing() throws InterruptedException {
		// 使用while编写该代码
		while (waxOn == false) {
			wait();
		}
	}

	synchronized void buffed() {
		waxOn = false;
		notifyAll();
	}

	synchronized void waitForBuffing() throws InterruptedException {
		// 使用while编写该代码
		while (waxOn == true) {
			wait();
		}
	}

}

/**
 * 如果Car被挂起，则该线程也会被
 * 
 * @author he
 *
 */
class WaxOn implements Runnable {
	private Car car;

	public WaxOn(Car c) {
		car = c;
	}

	public void run() {
		// 因将while()写在try语句里面 否则 线程终止后仍能继续运行

		try {
			while (!Thread.interrupted()) {
				System.out.println("Wax On");
				TimeUnit.MILLISECONDS.sleep(100);
				car.waxed();
				car.waitForBuffing();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Exiting via interrupt");

		}
		System.out.println("Ending wax on task");
	}
}

/**
 * 如果Car被挂起，则该线程也会被
 * 
 * @author he
 *
 */
class WaxOff implements Runnable {
	private Car car;

	public WaxOff(Car c) {
		car = c;
	}

	public void run() {
		// 因将while()写在try语句里面 否则 线程终止后仍能继续运行

		try {
			while (!Thread.interrupted()) {
				car.waitForWaxing();
				System.out.println("Wax Off");
				TimeUnit.MILLISECONDS.sleep(100);
				car.buffed();
			}

		} catch (InterruptedException e) {

			System.out.println("Exiting Wax Off ");

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
		TimeUnit.SECONDS.sleep(2);
		// 启动一次顺序关闭，执行以前提交的任务，但不接受新任务。
		// eService.shutdown();
		// 试图停止所有正在执行的活动任务，暂停处理正在等待的任务，并返回等待执行的任务列表。
		eService.shutdownNow();
	}
}
