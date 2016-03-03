package Number_1502;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ȱ��Ǳ�����ͻ��ƵĲ��� ���÷��䣡
 * 
 * @author he
 * 
 */

class Cat {
	public void speak() {
		System.out.println("����");
	}

	void sit() {
		System.out.println("Cat sit");
	}
}

class Dog {
	void speak() {
		System.out.println("����");
	}

	void sit() {
		System.out.println("Dog sit");
	}
}

class Test {

	static void perform(Object speaker) throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Class<?> c = speaker.getClass();//����һ������ʱ��class����
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
