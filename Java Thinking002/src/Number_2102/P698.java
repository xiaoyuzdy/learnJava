package Number_2102;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * nio类提供的I/O中断
 * 
 * @author he
 *
 */

class NIOBlocked implements Runnable {
	private final SocketChannel sc;

	public NIOBlocked(SocketChannel sc) {
		// TODO Auto-generated constructor stub
		this.sc = sc;
	}

	public void run() {
		try {
			System.out.println("Waiting for read()" +this);
			sc.read(ByteBuffer.allocate(1));
		} catch (IOException e) {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("I/O 线程被中断");
			}
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return sc.getClass().getName()+ this.hashCode();
	}
}

public class P698 {
	public static void main(String[] args) throws IOException, InterruptedException {
		ExecutorService eService = Executors.newCachedThreadPool();
		ServerSocket socket = new ServerSocket(8080);
		InetSocketAddress isa = new InetSocketAddress("localhost", 8080);
		SocketChannel sc1 = SocketChannel.open(isa);
		SocketChannel sc2 = SocketChannel.open(isa);

		Future<?> future = eService.submit(new NIOBlocked(sc1));
		eService.submit(new NIOBlocked(sc2));
		eService.shutdown();

		TimeUnit.SECONDS.sleep(2);
		future.cancel(true);
		
		TimeUnit.SECONDS.sleep(1);
		sc2.close();

	}
}
