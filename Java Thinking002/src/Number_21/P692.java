package Number_21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 仿真花园
 * 
 * 每个大门可以进入多个人，统计人数
 * 
 * @author he
 *
 */
// 大门
class Count {
	private int count;

	public synchronized int increment() {
		return count++;
	}

	public synchronized int value() {
		return count;
	}

}

class Entrance implements Runnable {
	private static Count count = new Count();
	private static List<Entrance> list = new ArrayList<Entrance>();
	private final int id;// entrance实例的ID
	private int number;// 统计人数

	public static volatile boolean canceled = false;

	Entrance(int id) {
		this.id = id;
		list.add(this);
	}

	public synchronized int getNumber() {
		return number;
	}

	public static void cancel() {
		canceled = true;
	}

	public void run() {
		while (!canceled) {
			//同步控制块
			synchronized(this){
				number++;
			}
			// this 指当前实例 调用toString()方法
		}
		System.out.println(this + " Toal " + count.increment());
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("sleep interrupted");
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Entrance id:" + id + "  人数:" + getNumber();
	}

	public static int getCount() {
		return count.value();
	}

	// 统计总人数
	public static int sumEntrances() {
		int sum = 0;
		for (Entrance entrance : list) {
			sum += entrance.getNumber();
		}
		return sum;
	}

}

public class P692 {

	public static void main(String[] args) throws Exception {
		ExecutorService eService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			eService.execute(new Entrance(i));
		}

		TimeUnit.SECONDS.sleep(3);
		// 将Entrance 的 canceled设置为 true
		Entrance.cancel();
		eService.shutdown();

		if (!eService.awaitTermination(200, TimeUnit.MICROSECONDS)) {
			System.out.println("有些线程在200毫米内未执行完");
		}

		System.out.println("Toal:" + Entrance.getCount());
		System.out.println("总人数:" + Entrance.sumEntrances());

	}
}
