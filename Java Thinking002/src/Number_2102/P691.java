package Number_2102;
/**
 * ��ֹ�����ڹ�����Դ�ϲ�����ͻ�ĵڶ��ַ�ʽ�Ǹ����Ա����Ĺ���
 * �����̴߳���ʱһ���Զ������ƣ�����Ϊʹ����ͬ������ÿ����ͬ���̶߳�������ͬ�Ĵ���
 */

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Access implements Runnable {

	final int id;

	public Access(int id) {
		this.id = id;
	}

	public void run() {
		// ����̲߳�����ֹ
		while (!Thread.currentThread().isInterrupted()) {
			P691.increment();
			System.out.println(this);
			Thread.yield();
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " #" +id+" id:"+ P691.get();
	}

}

public class P691 {

	private static ThreadLocal<Integer> tLocal = new ThreadLocal<Integer>() {
		// �����ڲ���
		private Random rand = new Random(47);

		// ���ص�ǰ��ʼֵ
		protected synchronized Integer initialValue() {
			return rand.nextInt(10000);
		}
	};

	//// threadLocal ��֤�˲�����־����������� increment��get���ý���ͬ�������̿���
	// ����ֵ
	public static void increment() {
		tLocal.set(get() + 1);
	}

	public static int get() {
		return tLocal.get();
	}

	public static void main(String[] args) throws Exception {
		ExecutorService eService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			eService.execute(new Access(i));
		}
		TimeUnit.SECONDS.sleep(3);;
		eService.shutdown();
	}
}
