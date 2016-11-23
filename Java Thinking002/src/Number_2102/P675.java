package Number_2102;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Number {
	private static int i;

	// ����ż��
	public static int next() {
		i++;
		i++;
		return i;
	}

	/**
	 * ���� synchronized�ؼ��� ��һ���̵߳��ø÷���ʱ��һ���̱߳�����
	 */
	// public synchronized static int next() {
	// i++;
	// i++;
	// return i;
	// }
	
	
	/**
	 * ͬ�����ƿ�,ע����Ϊ�Ǿ�̬��������ʹ������.class������ǷǾ�̬����ʹ��this
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
			// �����ȡ�Ĳ���ż����ֹͣ
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
		 * ����� xxxx(һ������) error
		 */
	}

}
