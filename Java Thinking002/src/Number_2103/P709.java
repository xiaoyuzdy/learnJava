package Number_2103;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * 使用同步队列BlockingQueue修改生产者和消费者问题
 * 
 * @author he
 *
 */

// 厨师类
class Chef3 implements Runnable {
	private BlockingQueue<Integer> queue;

	public Chef3(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	public void run() {
		try {
			while (!Thread.interrupted()) {
				queue.put(1);
				System.out.println("容器中加了一块肉,容器中还有" + queue.size() + "块肉");
			}

		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}

// 服务员类
class WaitPerson2 implements Runnable {
	private BlockingQueue<Integer> queue;

	public WaitPerson2(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {

		try {
			while (!Thread.interrupted()) {
				int i = queue.take();// 获取并移除头部，在元素变得可用之前一直等待
				System.out.println("从容器中拿走了" + i + "块肉，容器中还有" + queue.size() + "块肉");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class P709 {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10); // 队列中只能存放10个元素，模仿容器
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(new Chef3(queue));
		service.execute(new WaitPerson2(queue));
		service.shutdown();
		// 3后退出程序
		TimeUnit.SECONDS.sleep(3);
		System.exit(0);
	}

}
