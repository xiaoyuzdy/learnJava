package Number_2102;

import java.util.concurrent.TimeUnit;

/**
 * ���߳��ϵ���interrupt()ʱ���жϻᷢ����Ψһʱ����������Ҫ���뵽�������� ���� �Ѿ������������ڲ�ʱ
 * 
 * @author he
 *
 */
class NeedCleanup {
	final int id;
	public NeedCleanup(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
		System.out.println("Need clean up " + id);
	}
	public void cleanup() {
		System.out.println("Clean up " + id);
	}
}

class Blocked3 implements Runnable {
	public volatile double d = 0.0;
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {
				NeedCleanup n1 = new NeedCleanup(1);
				try {
					System.out.println("Sleep");
					TimeUnit.MICROSECONDS.sleep(100);
					NeedCleanup n2 = new NeedCleanup(2);
					try {
						System.out.println("Calculating");
						for (int i = 0; i < 10000; i++) {
							d += (Math.E + Math.PI) / d;
							System.out.println("Finished time-consuming operation");
						}
					} finally {
						n2.cleanup();
					}
				} finally {
					n1.cleanup();
				}
			}
			System.out.println("Exiting via while() test");
		} catch (InterruptedException e) {
			System.out.println("�߳��ж�");
		}
	}
}

public class P701 {
	public static void main(String[] args)  throws Exception{
		Thread t=new Thread(new Blocked3());
		t.start();
		TimeUnit.MICROSECONDS.sleep(1000);
		t.interrupt();
	}
}
