package Number_2102;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * ʹ��thread.UncaughtExceptionHandler�����쳣�����߳���ֹʱ���õĽӿ�
 * 
 * @author he
 *
 */
class ExceptionThread implements Runnable {
	public void run() {
		// �õ��̵߳�����
		Thread t = Thread.currentThread();

		System.out.println("eh " + t.getUncaughtExceptionHandler());
		throw new RuntimeException();

	}
}

// �����Լ����쳣����
class Myexcetpion implements Thread.UncaughtExceptionHandler {

	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("Exception " + e);

	}

}

class myThreadfactor implements ThreadFactory {

	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		// �����쳣����ӿ�
		t.setUncaughtExceptionHandler(new Myexcetpion());
		return t;
	}

}

public class P673 {
	public static void main(String[] args) {
		ExecutorService eService = Executors.newCachedThreadPool(new myThreadfactor());
		eService.execute(new ExceptionThread());

	}

}
