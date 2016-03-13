package Number_2103;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import Number_2103.Toast.Status;

/**
 * 使用同步队列进行同步控制 LinkedBlockingQueue 无界 ArrayBlockingQueue 有固定大小
 * 
 * @author he
 *
 */

class Toast {
	public enum Status {
		DRY, BUTTERED, JAMMED
	}

	private static Status status = Status.DRY;
	private final int id;

	public Toast(int id) {
		this.id = id;
	}

	public void butter() {
		status = Status.BUTTERED;
	}

	public void jam() {
		status = Status.JAMMED;
	}

	public int getId() {
		return id;
	}

	public static Status getStatus() {
		return status;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Toast" + id + ":" + status;
	}

}

class ToastQueue extends LinkedBlockingQueue<Toast> {
}

class Toaster implements Runnable {
	ToastQueue toastDry;
	private int count = 0;

	public Toaster(ToastQueue t) {
		toastDry = t;
	}

	public void run() {
		try {

			while (!Thread.interrupted()) {

				Toast t = new Toast(count++);
				System.out.println(t);
				toastDry.put(t);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Toaster off");
	}

}

class ToastButter implements Runnable {
	ToastQueue dryToast, butterToast;

	public ToastButter(ToastQueue dry, ToastQueue butter) {
		dryToast = dry;
		butterToast = butter;
	}

	public void run() {
		try {

			while (!Thread.interrupted()) {
				// 获取并移除头部，在元素变得可用之前一直等待
				Toast t = dryToast.take();
				t.butter();
				System.out.println(t);
				butterToast.put(t);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Butter  off");
	}

}

class ToastJam implements Runnable {
	ToastQueue butt, jam;

	public ToastJam(ToastQueue buf, ToastQueue j) {
		butt = buf;
		jam = j;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast t = butt.take();
				t.jam();
				System.out.println(t);
				jam.put(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Jam  off");
	}

}

class Eater implements Runnable {
	private ToastQueue fin;
	private int count = 0;

	public Eater(ToastQueue t) {
		fin = t;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast t = fin.take();
				if (t.getId() != count++ || t.getStatus() != Status.JAMMED) {
					System.out.println("Error" + t);
					System.exit(0);
				}
				else{
					System.out.println("Chomp "+t);
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

public class P716 {

	public static void main(String[] args) throws Exception {
		ExecutorService eService = Executors.newCachedThreadPool();
		ToastQueue dryQueue = new ToastQueue();
		ToastQueue butterQueue = new ToastQueue();
		ToastQueue jamQueue = new ToastQueue();

		eService.execute(new Toaster(dryQueue));
		eService.execute(new ToastButter(dryQueue, butterQueue));
		eService.execute(new ToastJam(butterQueue, jamQueue));
        eService.execute(new Eater(jamQueue));
		TimeUnit.MILLISECONDS.sleep(1);
		eService.shutdownNow();

	}

}
