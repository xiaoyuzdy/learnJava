package Number_1502;

/**
 * Á·Ï°34
 * 
 * @author he
 * 
 */

abstract class Base<T extends Base<T>> {
	abstract T A(T arg);

	T test() {
		return A(null);
	}
}

class Child extends Base<Child> {

	Child() {
	}

	@Override
	Child A(Child arg) {

		return arg;
	}

}

public class P409 {
	public static void main(String[] args) {
		Child a = new Child();

		System.out.println(a == a.A(a));
	}
}
