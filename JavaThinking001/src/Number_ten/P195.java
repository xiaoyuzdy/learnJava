package Number_ten;

/**
 * ����ת�� ָ������ӿڵ�����ʱ�������޷��ҵ�����ȷ������
 * 
 * @author he
 * 
 */

interface A {

}

interface B {

}

class Test {

	private class A1 implements A {

	}

	protected class B1 implements B {

	}

	public A creatA() {
		return new A1();
	}

	public B creatB() {
		return new B1();
	}

}

public class P195 {
	public static void main(String[] args) {
		Test t = new Test();

		A a1 = t.creatA(); // �ӿ�A����

		// Test.A1 b1 = t.new A1(); A1 Ϊprivate ���� �����಻�ܷ���

	}
}
