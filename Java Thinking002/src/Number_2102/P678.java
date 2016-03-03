package Number_2102;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 synchronized 实现同步化 保护数据域
 * 
 * @author he
 *
 */

abstract class Ingenerator {
	abstract int next1();

	abstract int next2();
}

class EvenChecker implements Runnable {
	public Ingenerator ingenerator;

	public EvenChecker(Ingenerator ing) {
		ingenerator = ing;

	}

	public void run() {
		int i = 100;
		int val = ingenerator.next1();
		int val2 = ingenerator.next2();
		while (true) {
			if (val % 2 == 0) {
				System.out.println(" synchronized " + val);
				
			}
			if (val2 % 2 == 0) {
				System.out.println(" no synchronized " + val2);
				
			}

		}

	}

	// 测试 创建多个线程
	public static void test(Ingenerator ing, int i) {
		ExecutorService eService = Executors.newCachedThreadPool();
		for (int k = 0; k < i; k++) {
			eService.execute(new EvenChecker(ing));
		}
		eService.shutdown();
	}
}

public class P678 extends Ingenerator {
	private   int count = 0;

	@Override
	// 用sychronized修饰

	synchronized int next1() {
		++count;
		// Thread.yield();
		++count;
		return count;
	}

	// 显示的加锁
	int next2() {
		Lock lock = new ReentrantLock();
		lock.lock();
		try {
			++count;
			Thread.yield();
			++count;
			return count;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		EvenChecker.test(new P678(), 5);
	}
}
