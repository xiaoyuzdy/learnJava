package Number_1502;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 缺乏潜在类型机制的补偿 利用反射！
 * 
 * @author he
 * 
 */

class Cat {
	public void speak() {
		System.out.println("喵喵");
	}

	void sit() {
		System.out.println("Cat sit");
	}
}

class Dog {
	void speak() {
		System.out.println("汪汪");
	}

	void sit() {
		System.out.println("Dog sit");
	}
}

class Test {

	static void perform(Object speaker) throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Class<?> c = speaker.getClass();//返回一个运行时的class对象
		Method method = c.getDeclaredMethod("speak");

		method.invoke(speaker);

		method = c.getDeclaredMethod("sit");
		method.invoke(speaker);

	}

}

public class P420 {
	public static void main(String[] args) throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Test.perform(new Cat());
		Test.perform(new Dog());
	}
}
