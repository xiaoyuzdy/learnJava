package Number_2103;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 生产者与消费者
 * 
 * @author he
 *
 */

class Meal2 {
	private volatile int count;

	public Meal2(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Meal2: " + count;
	}

}

class Wait implements Runnable {
	Rest rest;

	public Wait(Rest rest) {
		this.rest = rest;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (rest.meal == null) {
						wait();
					}
				}
				System.out.println("WaitPerson got:" + rest.meal);
				synchronized (rest.chef) {
					rest.meal = null;
					rest.chef.notifyAll();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

class Chef2 implements Runnable {
	Rest rest;
	int count = 0;

	public Chef2(Rest rest) {
		this.rest = rest;
	}

	public void run() {
		while (!Thread.interrupted()) {
			synchronized (this) {
				while (rest.meal != null) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			if (++count == 10) {
				System.out.println("中止");
				rest.eService.shutdownNow();
			}

			synchronized (rest.wait) {
				rest.meal = new Meal2(count);
				rest.wait.notifyAll();
			}

		}

	}

}

public class Rest {
	Meal2 meal;
	Wait wait = new Wait(this);
	Chef2 chef = new Chef2(this);

	ExecutorService eService = Executors.newCachedThreadPool();

	public Rest() {
		eService.execute(wait);
		eService.execute(chef);
	}

	public static void main(String[] args) {
		new Rest();
	}

}
