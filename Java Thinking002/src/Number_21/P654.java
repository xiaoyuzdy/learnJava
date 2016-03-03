package Number_21;

import java.util.concurrent.TimeUnit;

/**
 * 创建线程 实现runnable接口并重写run()方法
 */

public class P654 implements Runnable {
	protected int countDown = 10;
	private static int taskDown = 0;
	private final int id = taskDown++;

	P654() {

	}

	P654(int countDown) {
		this.countDown = countDown;
	}

	public String status() {

		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff")+ ")";

	}

	//run方法会无限调用  除非某个条件使run方法终止
	public void run() {
		while(countDown-->0){
			System.out.println(status());
//			Thread.yield();
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	};

	public static void main(String[] args) {
		P654 p=new P654();
		p.run();
	}
	
}
