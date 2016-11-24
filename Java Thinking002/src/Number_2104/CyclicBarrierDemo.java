package Number_2104;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * �˶�Ա��
 * 
 * @author he
 *
 */
class Athlete implements Runnable {
	private final int id;
	private CyclicBarrier barrier;
	private int distance = 0;// ����ͳ��ÿ���˶�Ա�ܹ��ľ���
	private static Random random = new Random(47);// ����ģ��ÿ���˶�Ա���ٶȲ�һ��

	public Athlete(int id, CyclicBarrier barrier) {
		this.barrier = barrier;
		this.id = id;
	}

	public synchronized int getDistance() {
		return distance;
	}

	/**
	 * ��ӡ�Ѿ��ܹ��ľ���
	 * 
	 * @return
	 */
	public String distance() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < getDistance(); i++)
			s.append("*");
		s.append(this);
		return s.toString();
	}

	@Override
	public String toString() {
		return id + " ���˶�Ա";
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					distance += random.nextInt(5); // �����ܹ��ľ���
				}
				barrier.await();// �����в����߶��Ѿ��ڴ� barrier�ϵ��� await ����֮ǰ����һֱ�ȴ���
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}

	}

}

public class CyclicBarrierDemo {

	private static final int destination = 50;// �����յ������50m
	private List<Athlete> athletes = new ArrayList<Athlete>();
	private ExecutorService service = Executors.newCachedThreadPool();
	private CyclicBarrier barrier;

	/**
	 * 
	 * @param nAthlete
	 *            ָ���̵߳����������м����˶�Ա
	 * @param pause
	 *            ָ������ʱ�䣬����ģ���˶�Ա����һ����������Ҫ��ʱ��
	 */
	public CyclicBarrierDemo(int nAthlete, final int pause) {

		barrier = new CyclicBarrier(nAthlete, new Runnable() {
			// run��������barrier��ֵΪ0ʱ����
			public void run() {
				StringBuilder s = new StringBuilder();
				for (int i = 0; i < destination; i++) {
					s.append("=");
				}
				System.out.println(s.toString());// ��ӡ�����ĳ���

				for (Athlete athlete : athletes)
					System.out.println(athlete.distance());// ��ӡ�˶�Ա�ܹ��ľ���
				for (Athlete a : athletes) {
					// ��������Ѿ������յ���ֹͣ���е��̣߳�����ֹ����
					if (a.getDistance() >= destination) {
						System.out.println(a+" Win");
						service.shutdownNow();
						return;
					}
				}
				
				try {
					TimeUnit.MILLISECONDS.sleep(pause);//���ߣ�ģ���˶�Ա����һ����������Ҫ��ʱ��
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});

		for (int i = 0; i < nAthlete; i++) {
			Athlete athlete = new Athlete(i, barrier);
			athletes.add(athlete);
			service.execute(athlete);
		}

	}

	public static void main(String[] args) {
		new CyclicBarrierDemo(5,500);
	}

}
