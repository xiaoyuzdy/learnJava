package Number_2103;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * ʹ��ͬ������BlockingQueue�޸������ߺ�����������
 * 
 * @author he
 *
 */

// ��ʦ��
class Chef3 implements Runnable {
	private BlockingQueue<Integer> queue;

	public Chef3(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	public void run() {
		try {
			while (!Thread.interrupted()) {
				queue.put(1);
				System.out.println("�����м���һ����,�����л���" + queue.size() + "����");
			}

		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}

// ����Ա��
class WaitPerson2 implements Runnable {
	private BlockingQueue<Integer> queue;

	public WaitPerson2(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {

		try {
			while (!Thread.interrupted()) {
				int i = queue.take();// ��ȡ���Ƴ�ͷ������Ԫ�ر�ÿ���֮ǰһֱ�ȴ�
				System.out.println("��������������" + i + "���⣬�����л���" + queue.size() + "����");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class P709 {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10); // ������ֻ�ܴ��10��Ԫ�أ�ģ������
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(new Chef3(queue));
		service.execute(new WaitPerson2(queue));
		service.shutdown();
		// 3���˳�����
		TimeUnit.SECONDS.sleep(3);
		System.exit(0);
	}

}
