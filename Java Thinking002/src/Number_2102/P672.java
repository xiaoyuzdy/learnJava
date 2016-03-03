package Number_2102;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程异常逃逸
 * 
 * 由于线程的本质特性，使得你不能捕获从线程中逃逸的异常 未捕获到异常；
 * 
 * @author he
 *
 */

class EXcept implements Runnable {
	public void run() {
		// TODO Auto-generated method stub
		throw new RuntimeException();
	}

}

public class P672 {

	public static void main(String[] args) {
		ExecutorService eService = Executors.newCachedThreadPool();
		eService.execute(new EXcept());
	}

}
