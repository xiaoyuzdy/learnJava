package Number_eight;

/**
 * ���๹�����е���һ�㷽�����Ҹ÷�������������д �򣬽������
 * 
 * 
 * �����ڻ��๹���������һ�㷽��ʱ Ҫ��֤�÷������ܱ���д����
 * 
 * 
 * @author he
 * 
 */

class A1 {
	void draw() {
		System.out.println("A.draw()");

	}

	public A1() {
		System.out.println("A1() before draw()");
		draw();
		System.out.println("A1() after draw()");
	}

}

class B1 extends A1 {

	private int readius = 1;

	public B1(int i) {
		readius = i;
		System.out.println("B1.B1(), readius=" + readius);

	}

	void draw() {
		System.out.println("B1.draw(),readius=" + readius);

	}
}

public class P163 {
	public static void main(String[] args) {
		new B1(5);
	}
}
