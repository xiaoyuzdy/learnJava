package Number_1502;

/**
 * ���޶�����
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

// ������ΪD����SelfBounded������
// class E extends SelfBounded<D>{}

public class P406 {
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
        //ѵ�����������
		Class c = Class.forName("Number_1502.A");
		A a1 = (A) c.newInstance();
		a1.set(new A());
		System.out.println(a1.get().getClass().getSimpleName());

	}
}
