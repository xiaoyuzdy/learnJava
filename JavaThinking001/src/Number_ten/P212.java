package Number_ten;

/**
 * �����ڲ���ļ̳�
 * 
 * @author he
 * 
 */

class Out {
	class inner {
		public inner() {
			System.out.println("this is inner class");
		}
	}
}

public class P212 extends Out.inner {

	P212(Out o) {    // �����ṩ����
		o.super(); // ���� inner �Ĺ�����
	}

	public static void main(String[] args) {
		Out o = new Out();
		P212 ii = new P212(o);
	}
}
