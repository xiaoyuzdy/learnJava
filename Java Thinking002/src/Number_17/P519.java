package Number_17;

import java.util.WeakHashMap;

/**
 * WeakHashMap 用来保存WeakReference
 * 
 * @author he
 * 
 */

class Element {
	private String ident;

	Element(String id) {
		ident = id;

	}

	@Override
	public String toString() {

		return ident;
	}

	@Override
	public int hashCode() {

		return ident.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return obj instanceof Element && ident.equals(((Element) obj).ident);
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalizing " + getClass().getSimpleName() + " "
				+ ident);
	}

}

class Key extends Element {

	Key(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

}

class Value extends Element {

	Value(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

}

public class P519 {
	public static void main(String[] args) {
		int size = 100;
		if (args.length > 0) {

			size = new Integer(args[0]);

		}

		Key[] keys = new Key[size];

		WeakHashMap<Key, Value> map = new WeakHashMap<Key, Value>();

		for (int i = 0; i < size; i++) {
			Key k = new Key(Integer.toString(i));
			Value v = new Value(Integer.toString(i));

			if (i % 3 == 0) {
				map.put(k, v); // 指向键的普通引用被存入了Keys数组，所以那些对象不能垃圾回收器回收
			}

		}
		System.gc();
	}

}
