package Number_six;

/**
 * ͳ�Ʊ������˶��ٶ��� private ���ι���������ֱֹ�Ӵ������ʵ��
 * 
 * @author he
 * 
 */

class Soup {
	private Soup() {
	}

	private static int i;

	public static Soup get() {

		f();
		return new Soup();

	}

	public static int f() {
		return i++;
	}
}

public class Text_P122 {
	public static void main(String[] args) {
		Soup sp1 = Soup.get();
		Soup sp2 = Soup.get();
		Soup sp3 = Soup.get();

		int sp = Soup.get().f();
		System.out.println(sp);
	}
}
