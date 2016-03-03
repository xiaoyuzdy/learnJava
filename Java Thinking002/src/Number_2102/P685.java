package Number_2102;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Á·Ï°14
 * 
 * @author he
 *
 */
public class P685 {
	static int i;

	static void print() {
		System.out.println(i++);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Timer().schedule(new TimerTask() {

				@Override
				public void run() {
					print();
				}
			}, 2);
		}

	}
}
