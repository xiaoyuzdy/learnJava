package Number_21;

import java.util.concurrent.TimeUnit;

/**
 * �����߳� ʵ��runnable�ӿڲ���дrun()����
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

	//run���������޵���  ����ĳ������ʹrun������ֹ
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
