package Number_2102;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Number {
	private static int i;

	// 产生偶数
	public static int next() {
		i++;
		i++;
		return i;
	}

	/**
	 * 加上 synchronized关键字 则当一个线程调用该方法时另一个线程被阻塞
	 */
	// public synchronized static int next() {
	// i++;
	// i++;
	// return i;
	// }
	
	
	/**
	 * 同步控制块,注意因为是静态方法所以使用类名.class，如果是非静态方法使用this
	 * @return
	 */
//	public  static int next() {
//		synchronized(Number.class){
//		 i++;
//		 i++;
//		}	
//		return i;
//	}
	

}

class A implements Runnable {
	private boolean ok = false;

	public void run() {
		int t = 0;
		while (true) {
			t = Number.next();
			// 如果获取的不是偶数就停止
			if (t % 2 != 0) {
				System.out.println(t + "  error");
				ok = true;
				System.exit(0);
			}
		}
	}

	public boolean isOk() {
		return ok;
	}

}

class B implements Runnable {
	private A a = new A();

	public void run() {
		while (true) {
			Number.next();
			if (a.isOk())
				System.exit(0);
		}
	}

}

public class P675 {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(new A());
		service.execute(new B());
		service.shutdown();

		/**
		 * 结果： xxxx(一个奇数) error
		 */
	}

}
