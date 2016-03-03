package Number_21;

import java.util.Arrays;

/**
 * ��ϰ2
 * �����̴߳���һ��쳲�����������ɵ�����
 * 
 * @author he
 *
 */
public class P656 implements Runnable {

	private int n;
	private int count;

	P656(int n1) {
		n = n1;
	}

	public int next() {
		return fib(count++);
	}

	public int fib(int n) {
		if (n < 2) {
			return 1;
		} else {
			return fib(n - 2) + fib(n - 1);
		}
	}

	public void run() {
		Integer[] i = new Integer[n];
		for (int j = 0; j < n; j++) {

			i[j] = next();
		}
		System.out.println("Seq.of" + " : " + Arrays.toString(i));
	}

	public static void main(String[] args) {
		for (int k = 1; k < 5; k++) {
			new Thread(new P656(k)).start();
		}

	}

}
