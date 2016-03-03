package Number_15;

/**
 * 泛型数组 只能将数组中的元素转型
 *  数组的底层是object 无法改变，无法推翻
 * 
 * @author he
 * 
 */
public class P385 {
	private Object[] array;

	P385(int size) {
		array = new Object[size];
	}

	public <T> void put(int index, T item) {
		array[index] = item;
	}

	@SuppressWarnings("unchecked")
	public <T> T getArray(int index) {
		return (T) array[index];
	}

	public <T> T[] rep() {
		return (T[]) array;
	}

	public static void main(String[] args) {
		P385 a = new P385(6);
		for (int i = 0; i < 5; i++) {
			a.put(i, i);
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(a.getArray(i));
		}

		a.put(5, "xx");
		System.out.println(a.getArray(5));

		try {
			// 由于底层是objec类型 所以异常
			Integer[] ia = a.rep();
			for (int i = 0; i < 5; i++) {
				System.out.println(ia[i]);
			}
		} catch (Exception e) {
			System.err.println(e);
		}

	}
}
