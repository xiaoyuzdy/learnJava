package Number_2102;

/**
 * ������������ 
 * ���ۺ�ʱֻҪ�����Բ����жϵķ�ʽ����������ô����Ǳ�ڵĻ���ס����Ŀ���
 * 
 * @author he
 *
 */
class MultiLock {
	synchronized static void f1(int count) {
		if (count-- > 0) {
			System.out.println("f1() calling f2() with count" + count);
			f2(count);
		}
	}

	synchronized static void f2(int count) {
		if (count-- > 0) {
			System.out.println("f2() calling f1() with count" + count);
			f1(count);
		}
	}

}

public class P699 {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				MultiLock.f1(10);
			};
		}.start();
	}
}
