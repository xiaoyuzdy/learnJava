package Number_twelve;

/**
 * ���ܼ���쳣 --->����ʱ�쳣
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
