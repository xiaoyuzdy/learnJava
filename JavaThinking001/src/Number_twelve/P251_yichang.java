package Number_twelve;

/**
 * �Զ����쳣
 * 
 * @author he
 * 
 */

class SimpleException extends Exception {
	SimpleException() {
	}

	SimpleException(String mes) {
		super(mes);
	}

	public void f() throws SimpleException {

		System.out.println("easy");

		throw new SimpleException("hahaha");

	}

}

public class P251_yichang {

	// public void f() throws SimpleException {
	//
	// System.out.println("easy");
	//
	// throw new SimpleException("hahaha");
	//
	// }

	public static void main(String[] args) {
		// P251_yichang a = new P251_yichang();
		SimpleException a = new SimpleException();

		try {
			a.f();
		} catch (SimpleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.err);
			System.out.println("��ƨ !!!" + e.getMessage());
			// �����׳��쳣
			try {
				// ֱ���׳��쳣ջ�켣��Ϣδˢ��
				/** ���:
				 * easy Number_twelve.SimpleException: hahaha at
				 * Number_twelve.SimpleException.f(P251_yichang.java:21) at
				 * Number_twelve.P251_yichang.main(P251_yichang.java:42) ��ƨ
				 * !!!hahaha Number_twelve.SimpleException: hahaha at
				 * Number_twelve.SimpleException.f(P251_yichang.java:21) at
				 * Number_twelve.P251_yichang.main(P251_yichang.java:42)
				 */
				
				
//				 throw e;

				
				// �����ڲ���¼ջ֡�ĵ�ǰ״̬ˢ��ջ�켣��Ϣ
				/**  ���:
				 * easy Number_twelve.SimpleException: hahaha at
				 * Number_twelve.SimpleException.f(P251_yichang.java:22) at
				 * Number_twelve.P251_yichang.main(P251_yichang.java:43) ��ƨ
				 * !!!hahaha Number_twelve.SimpleException: hahaha at
				 * Number_twelve.P251_yichang.main(P251_yichang.java:65)
				 */
				throw (Exception) e.fillInStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
		}

	}

}
