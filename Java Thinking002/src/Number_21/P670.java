package Number_21;

import java.util.concurrent.TimeUnit;

/**
 * ����һ���߳�
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
			// ����
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
				// ����thread.join����ʱ������ͣ���̣߳�ִ��a��run()����ֱ��a��run()������ִ��b��run()��
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
