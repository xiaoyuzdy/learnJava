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
 * 运动员类
 * 
 * @author he
 *
 */
class Athlete implements Runnable {
	private final int id;
	private CyclicBarrier barrier;
	private int distance = 0;// 用于统计每个运动员跑过的距离
	private static Random random = new Random(47);// 用于模拟每个运动员的速度不一样

	public Athlete(int id, CyclicBarrier barrier) {
		this.barrier = barrier;
		this.id = id;
	}

	public synchronized int getDistance() {
		return distance;
	}

	/**
	 * 打印已经跑过的距离
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
		return id + " 号运动员";
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					distance += random.nextInt(5); // 计算跑过的距离
				}
				barrier.await();// 在所有参与者都已经在此 barrier上调用 await 方法之前，将一直等待。
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}

	}

}

public class CyclicBarrierDemo {

	private static final int destination = 50;// 设置终点距离是50m
	private List<Athlete> athletes = new ArrayList<Athlete>();
	private ExecutorService service = Executors.newCachedThreadPool();
	private CyclicBarrier barrier;

	/**
	 * 
	 * @param nAthlete
	 *            指定线程的数量，即有几名运动员
	 * @param pause
	 *            指定休眠时间，用来模拟运动员跑完一定距离所需要的时间
	 */
	public CyclicBarrierDemo(int nAthlete, final int pause) {

		barrier = new CyclicBarrier(nAthlete, new Runnable() {
			// run方法会在barrier的值为0时调用
			public void run() {
				StringBuilder s = new StringBuilder();
				for (int i = 0; i < destination; i++) {
					s.append("=");
				}
				System.out.println(s.toString());// 打印赛道的长度

				for (Athlete athlete : athletes)
					System.out.println(athlete.distance());// 打印运动员跑过的距离
				for (Athlete a : athletes) {
					// 如果有人已经到达终点则，停止所有的线程，即终止比赛
					if (a.getDistance() >= destination) {
						System.out.println(a+" Win");
						service.shutdownNow();
						return;
					}
				}
				
				try {
					TimeUnit.MILLISECONDS.sleep(pause);//休眠，模拟运动员跑完一定距离所需要的时间
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
