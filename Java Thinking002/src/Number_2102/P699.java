package Number_2102;

/**
 * 被互斥锁阻塞 
 * 无论何时只要任务以不可中断的方式被阻塞，那么都有潜在的会锁住程序的可能
 * 
 * @author he
 *
 */
class MultiLock {
	synchronized static void f1(int count) {
		if (count-- > 0) {
			System.out.println("f1() calling f2() with count" + count);
			f2(count);
		}
	}

	synchronized static void f2(int count) {
		if (count-- > 0) {
			System.out.println("f2() calling f1() with count" + count);
			f1(count);
		}
	}

}

public class P699 {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				MultiLock.f1(10);
			};
		}.start();
	}
}
