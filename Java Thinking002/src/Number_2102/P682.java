package Number_2102;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 原子性，和易变性 原子操作： 除了long和double类型的基本类型的赋值和返回 非volatile的原子操作不惜刷新到主存中 所以还有刷新的问题
 * 
 * @author he
 *
 */
public class P682 implements Runnable {
	private  volatile static int i;
	

	public synchronized  static void en() {
		i++;
		i++;
	}

	public  synchronized static int get() {
		return i;
	}

	public void  run() {
		// TODO Auto-generated method stub
		while (true) {
			en();
		}

	}

	public static void main(String[] args) {
		ExecutorService eService = Executors.newCachedThreadPool();
		P682 p = new P682();
		eService.execute(p);
		while (true) {
			int val = p.get();
			if (val % 2 != 0) {
				System.out.println(val);
				System.exit(0);
			}
		}
	}

}