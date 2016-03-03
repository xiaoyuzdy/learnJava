package Number_21;

/**
 * 使用内部类，匿名内部类，内部方法创建线程
 * 
 * @author he
 *
 */

// 内部类 继承thread
class InnerThread1 {
	int countdown = 5;
	inner1 in;

	class inner1 extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
		}
	}

}

// 内部类 实现runnable 接口
class InnerRunnable1 {
	int countdown;
	inner2 in;

	class inner2 implements Runnable {
		Thread t;

		public inner2() {
			t = new Thread(in);
		}

		public void run() {

			while (true) {
				if (--countdown == 0) {
					return;
				}
			}
		}
	}
}

// 匿名内部类 Thread
class InnerThread2 {
	Thread t;

	public InnerThread2(String name) {
		t = new Thread(name) {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
			}
		};
	}
}

// 匿名内部类 runnable
class InnerRunnable2 {
	Thread t;

	InnerRunnable2() {
		t = new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub

			}
		});
	}

}

// 内部方法 thread
class ThreadMethod {
	Thread t;

	public void runTask(String name) {
		t = new Thread(name) {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
			}

		};
	}

}
