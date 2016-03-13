package Number_2103;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 练习30 用BlockingQueue 改写管道I/O
 * 
 * @author he
 *
 */

class Out implements Runnable {
	BlockingQueue<Character> bq;

	public Out(BlockingQueue<Character> b) {
		bq = b;
	}

	public void run() {
		try {
			while (true) {
				for (char c = 'A'; c <= 'Z'; c++) {
					bq.put(c);
					TimeUnit.MILLISECONDS.sleep(1);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

class In implements Runnable {
	private BlockingQueue<Character> bq;

	public In(BlockingQueue<Character> b) {
		bq = b;
	}

	public void run() {
		try {
			while (true) {
				char c = bq.take();
				System.out.println("Reader:"+c+", ");
				if (c=='Z') {
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}

public class P718 {
	public static void main(String[] args) throws Exception {
		ExecutorService eService = Executors.newCachedThreadPool();
		BlockingQueue<Character> bq = new LinkedBlockingQueue<Character>();

		eService.execute(new Out(bq));
		eService.execute(new In(bq));

		TimeUnit.SECONDS.sleep(2);
		eService.shutdownNow();

	}
}
