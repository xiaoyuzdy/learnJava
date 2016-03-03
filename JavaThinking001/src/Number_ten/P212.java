package Number_ten;

/**
 * 测试内部类的继承
 * 
 * @author he
 * 
 */

class Out {
	class inner {
		public inner() {
			System.out.println("this is inner class");
		}
	}
}

public class P212 extends Out.inner {

	P212(Out o) {    // 必须提供引用
		o.super(); // 调用 inner 的构造器
	}

	public static void main(String[] args) {
		Out o = new Out();
		P212 ii = new P212(o);
	}
}
