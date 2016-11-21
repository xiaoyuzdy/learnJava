package Number_2103;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * �����ľ������⣬��ѧ�ҾͲ�����
 * @author he
 *
 */
/**
 * ������
 * 
 * @author he
 *
 */
class Chopstick {
	private boolean taken = false;

	// ���������ռ��������߳�
	public synchronized void take() throws InterruptedException {
		while (taken)
			wait();
		taken = true;
	}

	// �ͷſ��ӣ������߳�
	public synchronized void drop() throws InterruptedException {
		taken = false;
		notifyAll();
	}

}

class Philosopher implements Runnable {

	private Chopstick left;
	private Chopstick right;
	private final int id;
	private final int ponderFactor;// ģ��˼����Ҫʱ���ʱ�����ӣ����ڲ�����ͬ��Χ�����ʱ��
	private Random random = new Random(47);

	// �÷�������ģ����ѧ��˼����ʱ�䡢�����ʱ��
	private void pause() throws InterruptedException {
		if (ponderFactor == 0)
			return;
		TimeUnit.MILLISECONDS.sleep(random.nextInt(ponderFactor * 300));
	}

	public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
		this.left = left;
		this.right = right;
		this.id = id;
		this.ponderFactor = ponderFactor;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println(this + " " + "thinking");
				pause();
				System.out.println(this + " ��ȡ�ұߵĿ���");
				right.take();
				System.out.println(this + " ��ȡ��ߵĿ���");
				left.take();
				System.out.println(this + " ���ڳ���");
				pause();
				right.drop();
				left.drop();
			}

		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

	@Override
	public String toString() {

		return "Philosopher  " + id;
	}

}



public class P722 {
	public static void main(String[] args) throws Exception {
		int size = 7;
		int ponder = 0;// ����Ϊ0���ھ���Ĳ�������

		ExecutorService service = Executors.newCachedThreadPool();
		Chopstick chopstick[] = new Chopstick[size];
		for (int i = 0; i < size; i++)
			chopstick[i] = new Chopstick();

		/**
		 * ��Ϊÿ����ѧ�Ҷ��������ұߵĿ��ӣ����Կ��ܻᷢ��ÿ���˶������ұߵĿ��Ӳ��ȴ���ߵĿ��ӵ��������ķ���
		 */
		for (int i = 0; i < size; i++)
			service.execute(new Philosopher(chopstick[i], chopstick[(i + 1) % size], i, ponder));

		/**
		 * ������һ����������ߵĿ��Ӻ����ұߵĿ�������Ա��������ķ������ƻ���ѭ���ȴ�������
		 */
//		for (int i = 0; i < size; i++) {
//			if (i < size - 1)
//				service.execute(new Philosopher(chopstick[i], chopstick[i + 1], i, ponder));
//			else
//				service.execute(new Philosopher(chopstick[0], chopstick[(i) % size], i, ponder));
//		}

		service.shutdown();

	}

}
