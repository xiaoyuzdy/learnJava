package Number_21;

/**
 * ʹ���ڲ��࣬�����ڲ��࣬�ڲ����������߳�
 * 
 * @author he
 *
 */

// �ڲ��� �̳�thread
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

// �ڲ��� ʵ��runnable �ӿ�
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

// �����ڲ��� Thread
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

// �����ڲ��� runnable
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

// �ڲ����� thread
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
