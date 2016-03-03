package Number_ten;

/**
 * ¶à²ãÇ¶Ì×
 * 
 * @author he
 * 
 */

class n_1 {
	private void f() {
		System.out.println("f()");
	};

	class n_2 {
		private void b() {
			System.out.println("b()");
		};

		class n_3 {
			void h() {
				f();
				b();
			}
		}
	}

}

public class P203_2 {
	public static void main(String[] args) {
		n_1 n1 = new n_1();
		n_1.n_2 n2 = n1.new n_2();
		n_1.n_2.n_3 n3 = n2.new n_3();
		n3.h();

	}
}
