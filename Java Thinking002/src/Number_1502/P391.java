package Number_1502;

import java.util.ArrayList;
import java.util.List;

/**
 * 边界及通配符
 * 
 * extends 上界 super 下界
 * 
 * @author he
 * 
 */

class Fruit {
}

class Apple extends Fruit {
};

class Apple2 extends Apple {
}

// 超类型通配符
class GenericWriting {
	static List<Apple> list1 = new ArrayList<Apple>();
	static List<Fruit> list2 = new ArrayList<Fruit>();

	public <T> void writeWithWlidcard(List<? super T> list, T item) {
		list.add(item);
	}

	public void f() {
		// T 为Apple 则可以添加本身 （本身及其子类安全）
		writeWithWlidcard(list1, new Apple());
		// 编译器无法判断？super Apple 是否安全 则 不允许！！！
		// writeWithWlidcard(list1, new Fruit());
		// T 为Fruit 可以添加其子类
		writeWithWlidcard(list2, new Apple());
	}

}

public class P391 {
	static void write(List<? super Apple> list2) {
		// Apple为下界 因此它的子类是安全的 ，所以可以add（）他的子类

		list2.add(new Apple2());// OK
		// 编译器无法检测Apple 基类的安全性 所以无法编译
		// list2.add(new Fruit());

	}

	static void write2(List<? extends Apple> list) {
		// add() 里的参数为 ？ extends Apple2
		// 编译器无法检测安全性 因此无法通过编译
		// list.add(new Apple2());
	}

	public static void main(String[] args) {
		// List<? extends Number> list = new ArrayList<Integer>();
		// list.add(0, null);
		// 不允许
		// list.add(1,3.f);
		// System.out.println(list.get(0));

	}
}
