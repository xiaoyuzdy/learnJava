package Number_21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ���滨԰
 * 
 * ÿ�����ſ��Խ������ˣ�ͳ������
 * 
 * @author he
 *
 */
// ����
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
	private final int id;// entranceʵ����ID
	private int number;// ͳ������

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
			//ͬ�����ƿ�
			synchronized(this){
				number++;
			}
			// this ָ��ǰʵ�� ����toString()����
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
		return "Entrance id:" + id + "  ����:" + getNumber();
	}

	public static int getCount() {
		return count.value();
	}

	// ͳ��������
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
		// ��Entrance �� canceled����Ϊ true
		Entrance.cancel();
		eService.shutdown();

		if (!eService.awaitTermination(200, TimeUnit.MICROSECONDS)) {
			System.out.println("��Щ�߳���200������δִ����");
		}

		System.out.println("Toal:" + Entrance.getCount());
		System.out.println("������:" + Entrance.sumEntrances());

	}
}
