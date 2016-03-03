package Number_2102;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ʹ��ͬ�����ƿ飬����ʹ���������ʶ����ʱ�������������
 * 
 * �ѷǱ������͵��࣬��������ı����Ϳ�����Ӧ���ڶ���̵߳Ļ���
 * 
 * @author he
 *
 */
// ���ܱ�������
class Pair {
	private int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pair() {
		this(0, 0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void incrementX() {
		x++;
	}

	public void incrementY() {
		y++;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "x:" + x + " , y:" + y;
	}

	// ����runtime �쳣
	class PairValueNotException extends RuntimeException {
		public PairValueNotException() {
			super("Pair values not equal: " + Pair.this);
		}

	}

	public void checkState() {
		if (x != y) {
			throw new PairValueNotException();
		}
	}

}

// �ܱ������� ��������ò��ܱ�������Pair
abstract class PairManger {
	// ԭ����
	AtomicInteger checkCounter = new AtomicInteger();
	protected Pair p = new Pair();
	// ����֧���߳�ͬ����List
	private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

	public synchronized Pair getPair() {
		return new Pair(p.getX(), p.getY());
	}

	protected void stor(Pair p) {
		storage.add(p);
		try {
			TimeUnit.MILLISECONDS.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ���󷽷� ��ʱ�ٽ����߳�ͬ������
	abstract void increment();
}

class PairManger1 extends PairManger {

	@Override
	// �߳�ͬ������
	synchronized void increment() {
		p.incrementX();
		p.incrementY();
		stor(getPair());

	}

}

class PairManger2 extends PairManger {

	@Override
	void increment() {
		Pair temp;

		// ͬ�����ƿ�
		synchronized (this) {
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}
		stor(temp);
	}
}

class PairManipulator implements Runnable {
	PairManger pm;

	public PairManipulator(PairManger pm) {
		this.pm = pm;

	}

	public void run() {
		while (true) {
			pm.increment();
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Pair" + pm.getPair() + " checkCounter " + pm.checkCounter.get();
	}
}
// ͳ��Ƶ��

class PairCheck implements Runnable {
	PairManger pm;

	public PairCheck(PairManger pm) {
		this.pm = pm;
	}

	public void run() {
		while (true) {
			// ��ԭ�ӷ�ʽ��checkCounter��1
			pm.checkCounter.incrementAndGet();
			pm.getPair().checkState();
		}

	}
}

public class P686 {
	static void test(PairManger pm1, PairManger pm2) {
		ExecutorService eService = Executors.newCachedThreadPool();
		PairManipulator pp1 = new PairManipulator(pm1);
		PairManipulator pp2 = new PairManipulator(pm2);

		PairCheck pc1 = new PairCheck(pm1);
		PairCheck pc2 = new PairCheck(pm2);

		eService.execute(pp1);
		eService.execute(pp2);
		eService.execute(pc1);
		eService.execute(pc2);

		try {
			TimeUnit.MILLISECONDS.sleep(200);
		} catch (Exception e) {
			System.out.println("sleep interruoted");
		}

		System.out.println("pp1: " + pp1 + "\npp2: " + pp2);
		System.exit(0);

	}

	public static void main(String[] args) {
		PairManger pm1 = new PairManger1();
		PairManger pm2 = new PairManger2();
		test(pm1, pm2);
	}

}
