package Number_ten;

/**
 * 向上转型 指向基类或接口的引用时，可能无法找到它的确切类型
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

		A a1 = t.creatA(); // 接口A引用

		// Test.A1 b1 = t.new A1(); A1 为private 类型 除本类不能访问

	}
}
