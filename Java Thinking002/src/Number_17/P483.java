package Number_17;

/**
 * 通过关联数组自定义Map
 * 
 * @author he
 * 
 */

class AssociativeArray<K, V> {
	private int index;
	private Object[][] pair;

	AssociativeArray(int length) {
		pair = new Object[length][2];
	}

	public void put(K key, V value) throws Exception {
		if (index >= pair.length) {
			throw new IndexOutOfBoundsException();
		}

		pair[index++] = new Object[] { key, value };

	}

	@SuppressWarnings("unchecked")
	public V get(K key) {

		for (int i = 0; i < index; i++) {
			if (key.equals(pair[index][0])) {
				return (V) pair[index][1];
			}
		}

		return null;

	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < index; i++) {
			s.append(pair[i][0].toString());
			s.append(":");
			s.append(pair[i][1].toString());
			if (i < index - 1) {
				s.append("\n");
			}

		}

		return s.toString();

	}

}

public class P483 {
	public static void main(String[] args) {
		AssociativeArray<String, String> a = new AssociativeArray<String, String>(
				3);
		try {
			a.put("A", "a");
			a.put("B", "b");
			a.put("C", "c");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			a.put("D", "d");
		} catch (Exception e) {
			System.out.println("越界" + e);
		}

		System.out.println(a);
		System.out.println(a.get("A"));

	}
}
