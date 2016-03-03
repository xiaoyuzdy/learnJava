package Number_six;

/**
 * 统计被创建了多少对象 private 修饰构造器，阻止直接创建类的实例
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
