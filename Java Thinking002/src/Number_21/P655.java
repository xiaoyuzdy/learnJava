package Number_21;

/**
 * thread ��
 * 
 * @author he
 *
 */
public class P655 {
	public static void main(String[] args) {
		// ����threadʵ�� �������д�ʵ����runnable���࣬ .start() ִ�и��߳�
		for (int i = 0; i < 5; i++) {
			new Thread(new P654()).start();

		}
		System.out.println("waiting for p654()");
	}
}
