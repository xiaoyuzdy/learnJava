package Number_fourteen;

import java.util.Random;

/**
 * 1.类字面常量 .class 和 forname()方法的区别 
 * 2.编译期常量
 * 
 * @author he
 * 
 */

class Initable {
	static final int staticFinal = 47;
	final static int staticFinal2 = 48;

	static final int staticFinal3 = P319.rand.nextInt(1000);

	static {
		System.out.println("初始化1");
	}

}

class Initable2 {
	// static final 和 final static 无区别 修饰编译期常量 无需对类初始化
	static int initable1 = 147;
	final int initable2 = 148;
	static {
		System.out.println("初始化2");
	}

}

class Initable3 {

	static int initable31 = 44;
	static {
		System.out.println("初始化3");
	}

}

public class P319 {
	public static Random rand = new Random(47);

	public static void main(String[] args) throws ClassNotFoundException {
		// 只适用.class生成对class对象的引用 未初始化
		Class c = Initable.class;
		// 编译器常量 无需对类初始化
		System.out.println(Initable.staticFinal);
		System.out.println(Initable.staticFinal2);
		System.out.println("-------------------");
		// 需要先对类初始化后才能读取
		System.out.println(Initable.staticFinal3);
		System.out.println("-------------------");
		System.out.println(Initable2.initable1);
		System.out.println("-------------------");
		// 使用forname()方法 需对类进行初始化
		Class c2 = Class.forName("Number_fourteen.Initable3");

		System.out.println("=================");

		System.out.println(Initable3.initable31);

	}
}
