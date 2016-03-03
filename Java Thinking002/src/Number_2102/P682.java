package Number_2102;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ԭ���ԣ����ױ��� ԭ�Ӳ����� ����long��double���͵Ļ������͵ĸ�ֵ�ͷ��� ��volatile��ԭ�Ӳ�����ϧˢ�µ������� ���Ի���ˢ�µ�����
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