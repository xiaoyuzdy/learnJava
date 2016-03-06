package Number_2102;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ��ReentrantLock������������߱����Ա��жϵ�����
 * 
 * @author he
 *
 */

class BlockedMutex {
	private Lock lock = new ReentrantLock();

	public BlockedMutex() {
		// TODO Auto-generated constructor stub
		// ����
		lock.lock();
	}

	public void f() {
		// ����߳�δ���жϻ�ȡ��
		try {
			// lock.lockInterruptibly();
			System.out.println("lock acquired in f()");

		}
		// InterruptedException
		// ���߳��ڻ֮ǰ���ڼ䴦�����ڵȴ������߻�ռ��״̬�Ҹ��̱߳��ж�ʱ���׳����쳣��

		finally {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("�̱߳��ж�");
			}
		}
	}

}

class Blocked2 implements Runnable {
	BlockedMutex b = new BlockedMutex();

	public void run() {
		// TODO Auto-generated method stub

		System.out.println("Wating for f() in BlockedMutex");
		// ����BlockedMutex�������Ҳ��ͷ� ����b.f������Զ�޷�ִ��
		b.f();

	}

}

public class P700 {
	public static void main(String[] args) {
		Thread t = new Thread(new Blocked2());
		t.start();
		t.interrupt();
	}
}
