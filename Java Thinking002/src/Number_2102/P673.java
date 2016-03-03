package Number_2102;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 使用thread.UncaughtExceptionHandler，因异常导致线程终止时调用的接口
 * 
 * @author he
 *
 */
class ExceptionThread implements Runnable {
	public void run() {
		// 得到线程的引用
		Thread t = Thread.currentThread();

		System.out.println("eh " + t.getUncaughtExceptionHandler());
		throw new RuntimeException();

	}
}

// 定义自己的异常处理
class Myexcetpion implements Thread.UncaughtExceptionHandler {

	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("Exception " + e);

	}

}

class myThreadfactor implements ThreadFactory {

	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		// 设置异常处理接口
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
