package Number_eight;

/**
 * ��Ա��������̬����û�ж�̬ ��Ա��������ǰ�ڰ� �� ��̬���ں��ڰ� ��̬������������������޹�
 * 
 * @author he
 * 
 */

class A {
	public int i = 0;

	public int getI() {
		return i;
	}

	public static String staticGet() {
		return "A staticGet";
	}

	public String dynamicGet() {
		return "A dynamicGet";
	}
}

class B extends A {
	public int i = 1;

	public int getI() {
		return i;
	}

	public int getSuperI() {
		return super.i;
	}

	public static String staticGet() {
		return "B staticGet";
	}

	public String dynamicGet() {
		return "B dynamicGet";
	}
}

public class Static_p156 {
	public static void main(String[] args) {

		A first = new B();
		// ���Գ�Ա����
		// ��Ա����ָ�� ���õĳ�Ա����
		System.out.println("first.i=" + first.i + "     first.Geti="
				+ first.getI());
		B two = new B();
		System.out.println("two.i=" + two.i + "        two.GetI=" + two.getI()
				+ "      two.getsuperI=" + two.getSuperI());

		A third = new B();
		// ���Ծ�̬����
		// ��̬������������������޹�
		System.out.println(third.staticGet());
		System.out.println(third.dynamicGet());

	}
}
