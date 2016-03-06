package Number_2102;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在ReentrantLock上阻塞的任务具备可以被中断的能力
 * 
 * @author he
 *
 */

class BlockedMutex {
	private Lock lock = new ReentrantLock();

	public BlockedMutex() {
		// TODO Auto-generated constructor stub
		// 上锁
		lock.lock();
	}

	public void f() {
		// 如果线程未被中断获取锁
		try {
			// lock.lockInterruptibly();
			System.out.println("lock acquired in f()");

		}
		// InterruptedException
		// 当线程在活动之前或活动期间处于正在等待、休眠或占用状态且该线程被中断时，抛出该异常。

		finally {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("线程被中断");
			}
		}
	}

}

class Blocked2 implements Runnable {
	BlockedMutex b = new BlockedMutex();

	public void run() {
		// TODO Auto-generated method stub

		System.out.println("Wating for f() in BlockedMutex");
		// 由于BlockedMutex被上锁且不释放 所以b.f（）永远无法执行
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
