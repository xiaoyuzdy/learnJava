package Number_1502;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 可变参数列表和反射的方式
 * 
 * @author he
 * 
 */
class Cat1 {
	public void speak(String s) {
		System.out.println("喵喵");
	}

	public void sit() {
		System.out.println("Cat sit");
	}
}

class Dog1 {
	void speak(String s) {
		System.out.println("汪汪");
	}

	void sit() {
		System.out.println("Dog sit");
	}
}

class Test1 {

	public static <T, S extends Iterable<T>> void perform(S obj,
			Method method, Object... args) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		for (T t : obj) {
			method.invoke(t, args);
		}

	}

}

public class P421 {

	public static void main(String[] args) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		List<Cat1> list = new ArrayList<Cat1>();
		for (int i = 0; i < 3; i++) {
			list.add(new Cat1());
		}
		Test1.perform(list, Cat1.class.getDeclaredMethod("sit"));
		Test1.perform(list,
				Cat1.class.getDeclaredMethod("speak", String.class), "speak");
	}
}
