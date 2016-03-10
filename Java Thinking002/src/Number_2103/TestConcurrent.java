package Number_2103;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Bus {
	private boolean b = false;

	public synchronized void close() {
		b = true;
		notifyAll();
	}

	synchronized void open() {
		b = false;
		notifyAll();
	}

	synchronized void closeWait() throws InterruptedException {
		while (b == false) {
			wait();
		}
	}

	synchronized void openWait() throws InterruptedException {
		while (b == true) {
			wait();
		}
	}

}

class Open implements Runnable {
	private Bus bus;

	public Open(Bus bus) {
		this.bus = bus;

	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println("Bus open");
				 TimeUnit.MILLISECONDS.sleep(100);
				bus.open();
				bus.closeWait();
			}
		} catch (Exception e) {
			System.out.println("open �ж�");
		}

	}

}

class Close implements Runnable {
	private Bus bus;

	public Close(Bus bus) {
		this.bus = bus;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				bus.openWait();
				System.out.println("Bus Close");
				 TimeUnit.MILLISECONDS.sleep(100);
				bus.close();
			}

		} catch (Exception e) {
			System.out.println("close �ж�");
		}

	}

}

public class TestConcurrent {
	public static void main(String[] args) throws Exception{
		Bus bus = new Bus();
		ExecutorService eService = Executors.newCachedThreadPool();

		eService.execute(new Open(bus));
		eService.execute(new Close(bus));
		TimeUnit.SECONDS.sleep(2);
		//����һ��˳��رգ�ִ����ǰ�ύ�����񣬵�������������
		// eService.shutdown();
		// ��ͼֹͣ��������ִ�еĻ������ͣ�������ڵȴ������񣬲����صȴ�ִ�е������б�
        eService.shutdownNow();

	}
}
