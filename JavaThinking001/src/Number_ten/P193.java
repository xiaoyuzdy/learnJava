package Number_ten;

/**
 * .this 的使用
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
		P193.Inner dti = x.inner();// 内部类的引用
		dti.outer().f();// 调用内部类的outer方法返回一个外部类的引用
	}
}
