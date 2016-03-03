package Number_15;

/**
 * Á·Ï°25
 * 
 * @author he
 * 
 */

interface A {
	void A();
}

interface B {
	void B();
}

class C1 implements A, B {

	public void B() {
		System.out.println("B");
	}

	public void A() {
		System.out.println("A");
	}

}

public class P389<T> {
	static <T extends A> void getA(T object) {
		object.A();
	}

	static <T extends B> void getB(T object) {
		object.B();
	}

	public static void main(String[] args) {
		C1 c = new C1();
		getA(c);
		getB(c);

	}

}
