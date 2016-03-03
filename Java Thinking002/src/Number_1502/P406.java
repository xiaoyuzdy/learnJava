package Number_1502;

/**
 * 自限定泛型
 * 
 * @author he
 * 
 */

class SelfBounded<T extends SelfBounded<T>> {
	T args;

	SelfBounded set(T item) {
		args = item;
		return this;
	}

	T get() {
		return args;
	}

}

class A extends SelfBounded<A> {
}

class C extends SelfBounded<A> {
}

class D {
}

// 错误，因为D不是SelfBounded的子类
// class E extends SelfBounded<D>{}

public class P406 {
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
        //训练反射的掌握
		Class c = Class.forName("Number_1502.A");
		A a1 = (A) c.newInstance();
		a1.set(new A());
		System.out.println(a1.get().getClass().getSimpleName());

	}
}
