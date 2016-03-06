package Number_2102;

/**
 * 在其他对象上同步
 * 
 * @author he
 *
 */

class DuslSynch implements Runnable {
	private Object syncObject = new Object();

	synchronized static void f() {
		for (int i = 0; i < 5; i++) {
			System.out.println("f()");
			Thread.yield();
		}
	}

	void g() {
		synchronized (syncObject) { // 在syncObject上进行同步控制
			for (int i = 0; i < 5; i++) {
				System.out.println("g()");
				Thread.yield();
			}

		}
	}

	public void run() {
		f();
	}

}

public class P689 {
	public static void main(String[] args) {
	    DuslSynch ds = new DuslSynch();
		new Thread(ds).start();
		ds.g();
	}
}
