package Number_2103;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 任务间使用管道进行输入/输出
 * 
 * @author he
 *
 */

class Sender implements Runnable {
	private Random random = new Random(47);
	private PipedWriter out = new PipedWriter();

	public PipedWriter getOut() {
		return out;
	}

	public void run() {
		try {
			while (true) {
				for (char c = 'A'; c <= 'Z'; c++) {
					out.write(c);
					TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}

class pipedIn implements Runnable {
	private PipedReader in;

	public pipedIn(Sender sender) throws IOException {
		// TODO Auto-generated constructor stub
		in = new PipedReader(sender.getOut());

	}

	public void run() {
		try {
			while (true) {
				System.out.println("Reader:" + (char) in.read() + ", ");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}

public class P717 {
	public static void main(String[] args) throws Exception{
		Sender sender = new Sender();
		pipedIn in=new pipedIn(sender);
		
		ExecutorService eService=Executors.newCachedThreadPool();
		eService.execute(sender);
		eService.execute(in);
		
		TimeUnit.SECONDS.sleep(4);
		eService.shutdownNow();
		
		

	}

}
