package Number_ten;

/**
 * .this ��ʹ��
 * 
 * @author he
 * 
 */
public class P193 {

	void f() {
		System.out.println(" void f()");

	}

	class Inner {
		public P193 outer() {
			return P193.this;
		}

	}

	public Inner inner() {
		return new Inner();
	}

	public static void main(String[] args) {
		P193 x = new P193();
		P193.Inner dti = x.inner();// �ڲ��������
		dti.outer().f();// �����ڲ����outer��������һ���ⲿ�������
	}
}
