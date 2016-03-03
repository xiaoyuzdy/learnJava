package Number_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̵߳����ȼ� ���ȼ���run�����Ŀ�ͷ�����趨
 */
public class P660 implements Runnable {
	private int countdown = 4;
	private volatile double d;// ��ֹ���������Ż�
	private int priority;

	P660(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// �����̵߳�����
		return Thread.currentThread() + " : " + countdown;
	}

	public void run() {
		// �����̵߳����ȼ�
		Thread.currentThread().setPriority(priority);
		while (true) {
			// forѭ����Ŀ����Ϊ�˿����������ȼ���Ч��
			for (int i = 0; i < 100000; i++) {
				d += (Math.PI + Math.E) / (double) i;
				if (i % 1000 == 0) {
					Thread.yield();
				}
			}

			System.out.println(this);
			if (--countdown == 0) {
				return;
			}

		}

	}

	public static void main(String[] args) {
		ExecutorService eService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			eService.execute(new P660(Thread.MIN_PRIORITY));
		}
		// ���ȼ����
		eService.execute(new P660(Thread.MAX_PRIORITY));
		eService.shutdown();
	}

}
