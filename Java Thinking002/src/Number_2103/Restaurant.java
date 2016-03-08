package Number_2103;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * P709 生产者与消费者
 * 
 * @author he
 *
 */

class Meal {
	private final int count;

	public Meal(int count) {
		this.count = count;
	}

	@Override
	public String toString() {

		return "Meal " + count;
	}

}

class WaitPerson implements Runnable {
	private Restaurant restaurant;

	public WaitPerson(Restaurant r) {
		restaurant = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (restaurant.meal == null) {
						wait();
					}
				}
				System.out.println("WaitPerson got:" + restaurant.meal);

				synchronized (restaurant.chef) {
					restaurant.meal = null;
					restaurant.chef.notifyAll();
				}

			}

		} catch (InterruptedException e) {
			System.out.println("WaitPerson interruped");
		}

	}

}

class Chef implements Runnable {
	private Restaurant restaurant;
	private int count = 0;

	public Chef(Restaurant r) {
		restaurant = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (restaurant.meal != null) {
						wait();
					}
				}

				if (++count == 10) {
					System.out.println("停止出售");
					restaurant.eService.shutdownNow();
				}

				TimeUnit.MICROSECONDS.sleep(100);
				System.out.print("Order up");
				synchronized (restaurant.waitPerson) {
					restaurant.meal = new Meal(count);
					// 唤醒服务员线程
					restaurant.waitPerson.notifyAll();
				}
			}

		} catch (InterruptedException e) {
			System.out.println("退出线程");
		}

	}
}

public class Restaurant {
	Meal meal;
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);

	ExecutorService eService = Executors.newCachedThreadPool();
	
	public Restaurant() {
		eService.execute(chef);
		eService.execute(waitPerson);
	}
	
	public static void main(String[] args) {
		new Restaurant();
	}
}
