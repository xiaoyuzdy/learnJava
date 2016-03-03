package Number_eight;

/**
 * 基类构造器中调用一般方法并且该方法在子类中重写 则，结果出错
 * 
 * 
 * 所以在基类构造器里调用一般方法时 要保证该方法不能被重写覆盖
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
