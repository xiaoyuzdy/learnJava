package Number_15;

/**
 * 泛型的边界 习题20
 * 
 * @author he
 * @param <T>
 * 
 */
interface AB {
	public void A();

	public void B();

}

class D {

	public <T extends AB> void f(T a) {
		a.A();
		a.B();
//		a.C();
	}
}

class C implements AB {

	public void A() {
		System.out.println("A");
	}

	public void B() {
		System.out.println("B");
	}

	public void C() {
		System.out.println("C");
	}
}

public class P375 {
	public static void main(String[] args) {
		D d = new D();
		d.f(new C());
	}
}
