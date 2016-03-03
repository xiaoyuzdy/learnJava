package Number_eight;

/**
 * 成员变量，静态方法没有多态 成员变量属于前期绑定 ， 多态属于后期绑定 静态方法从属于类与对象无关
 * 
 * @author he
 * 
 */

class A {
	public int i = 0;

	public int getI() {
		return i;
	}

	public static String staticGet() {
		return "A staticGet";
	}

	public String dynamicGet() {
		return "A dynamicGet";
	}
}

class B extends A {
	public int i = 1;

	public int getI() {
		return i;
	}

	public int getSuperI() {
		return super.i;
	}

	public static String staticGet() {
		return "B staticGet";
	}

	public String dynamicGet() {
		return "B dynamicGet";
	}
}

public class Static_p156 {
	public static void main(String[] args) {

		A first = new B();
		// 测试成员变量
		// 成员变量指向 引用的成员变量
		System.out.println("first.i=" + first.i + "     first.Geti="
				+ first.getI());
		B two = new B();
		System.out.println("two.i=" + two.i + "        two.GetI=" + two.getI()
				+ "      two.getsuperI=" + two.getSuperI());

		A third = new B();
		// 测试静态方法
		// 静态方法从属于类与对象无关
		System.out.println(third.staticGet());
		System.out.println(third.dynamicGet());

	}
}
