package Number_2103;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * notifyAll() 只能唤醒特定锁 wait()的线程 该特定锁与底层对象有关 ---->
 * 
 * @author he
 *
 */
class Blocker {
	synchronized void waitingforCall() {

		try {
			while (!Thread.interrupted()) {
				wait();
				System.out.println(Thread.currentThread().hashCode() + "----");
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	synchronized void prod() {
		notify();
	}

	synchronized void prodAll() {
		notifyAll();
	}
}

class Task implements Runnable {
	static Blocker b1;

	public Task(Blocker b) {
		b1 = b;

	}

	public synchronized void run() {
		// TODO Auto-generated method stub
		b1.waitingforCall();

	}

}

class Task2 implements Runnable {
	static Blocker b2;

	public Task2(Blocker b) {
		b2 = b;
	}

	public synchronized void run() {
		// TODO Auto-generated method stub
		b2.waitingforCall();
	}
}

public class P707 {
	public static void main(String[] args) throws Exception {
		ExecutorService eService = Executors.newCachedThreadPool();
		Blocker b = new Blocker();
		Blocker b2 = new Blocker();

		eService.execute(new Task(b));
		eService.execute(new Task2(b));
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			boolean pro = true;

			@Override
			public void run() {
				if (pro) {
					Task.b1.prod();
					pro = false;
				} else {
					Task.b1.prodAll();
					pro = true;
				}

			}
		}, 400, 400);

		TimeUnit.SECONDS.sleep(5);
		;
		t.cancel();
		System.out.println(" timer cancled");
		TimeUnit.MICROSECONDS.sleep(500);
		Task2.b2.prodAll();
		TimeUnit.MICROSECONDS.sleep(5000);
		System.out.println("Shutting down");
		eService.shutdown();

	}

}
