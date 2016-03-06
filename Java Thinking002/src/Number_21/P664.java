package Number_21;

import java.util.concurrent.TimeUnit;

/**
 * ���һ���߳��Ǻ�̨����ô�����������߳��Զ�����Ϊ��̨�߳�
 * 
 * @author he
 *
 */

class Daemon implements Runnable {
	Thread t[] = new Thread[10];

	public void run() {
		for (int i = 0; i < t.length; i++) {
			// �������߳�
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			System.out.println("DameonSpawn " + i + " started");
		}
		// �ж��ǲ��Ǻ�̨�߳�
		for (int i = 0; i < t.length; i++) {
			System.out.println("t[" + i + "]" + "is Daemon" + t[i].isDaemon());
		}

		while (true) {
			Thread.yield();
		}
	}

}

class DaemonSpawn implements Runnable {
	public void run() {
		// TODO Auto-generated method stub
		Thread.yield();
	}
}

public class P664 {

	public static void main(String[] args) throws Exception {
		Thread tt = new Thread(new Daemon());
		// ����Ϊ��̨�߳�
		tt.setDaemon(true);
		tt.start();

		System.out.println("is Daemon ? " + tt.isDaemon());
		// ����Ҫ����仰����Ȼ�̲߳����� ����Ϊ���õ��Ǻ�̨�̣߳���main�ǷǺ�̨�̣߳�
		// ���Ե�main������JVM���Զ��ر����к�̨�߳�
//		TimeUnit.MILLISECONDS.sleep(1);
		// ����
		// tt.sleep(1);
	}

}
