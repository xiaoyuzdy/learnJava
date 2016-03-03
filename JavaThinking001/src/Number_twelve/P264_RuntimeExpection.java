package Number_twelve;

/**
 * 不受检查异常 --->运行时异常
 * @author he
 * 
 */
public class P264_RuntimeExpection {

	static void f() {
		throw new RuntimeException();
	}

	static void g() {
		f();
	}

	public static void main(String[] args) {

		g();

	}
}
