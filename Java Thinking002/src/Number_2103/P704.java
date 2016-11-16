package Number_2103;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * �߳�֮���Э��
 * 
 * @author he
 *
 */

class Car {
	private boolean waxOn = false;

	synchronized void waxed() {
		waxOn = true;
		notifyAll();// ���Ѽ����������е��߳�
	}

	synchronized void waitForWaxing() throws InterruptedException {
		// ʹ��while��д�ô���
		while (waxOn == false) {
			wait();
		}
	}

	synchronized void buffed() {
		waxOn = false;
		notifyAll();
	}

	synchronized void waitForBuffing() throws InterruptedException {
		// ʹ��while��д�ô���
		while (waxOn == true) {
			wait();
		}
	}

}

/**
 * ���Car����������߳�Ҳ�ᱻ
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
		// ��while()д��try������� ���� �߳���ֹ�����ܼ�������

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
 * ���Car����������߳�Ҳ�ᱻ
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
		// ��while()д��try������� ���� �߳���ֹ�����ܼ�������

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
		// ����һ��˳��رգ�ִ����ǰ�ύ�����񣬵�������������
		// eService.shutdown();
		// ��ͼֹͣ��������ִ�еĻ������ͣ�������ڵȴ������񣬲����صȴ�ִ�е������б�
		eService.shutdownNow();
	}
}
