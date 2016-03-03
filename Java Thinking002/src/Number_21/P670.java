package Number_21;

import java.util.concurrent.TimeUnit;

/**
 * 加入一个线程
 * 
 * @author he
 */

class A extends Thread {
	int countdown = 4;

	A(String name) {
		super(name);
		start();
	}

	@Override
	public void run() {
		while (--countdown > 0) {
			// 休眠
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("A");
		}
	}

}

class B extends Thread {
	int countdown = 5;
	A a;

	B(String name, A a) {
		super(name);
		this.a = a;
		start();
	}

	@Override
	public void run() {

		while (--countdown > 0) {
			if (countdown == 2) {
				// 读到thread.join（）时会先暂停该线程，执行a的run()方法直到a的run()结束再执行b的run()；
				try {
					a.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			System.out.println("B");
		}

	}

}

public class P670 {
	public static void main(String[] args) {

		B b = new B("B1", new A("A1"));

	}

}
