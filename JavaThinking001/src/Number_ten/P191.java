package Number_ten;
/**
 * 外部类有一个放法，该方法返回一个指定的内部类的引用
 * 
 * @author he
 *
 */

public class P191 {
	class A {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	class B {
		private String label;

		B(String i) {
			label = i;
		}

		String readLabel() {
			return label;
		}
	}

	public B to(String s) {
		return new B(s);
	}

	public A a() {
		return new A();
	}

	public void Ship(String dest) {
		A c = a();
		B d = to(dest);
		System.out.println(d.readLabel());
	}

	public static void main(String[] args) {
		P191 p1 = new P191();
		p1.Ship("ok");
		P191 p2 = new P191();
		P191.A a1 = p2.a();
		P191.B b1 = p2.to("xx");
	}
}
