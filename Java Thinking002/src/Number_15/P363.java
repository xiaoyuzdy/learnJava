package Number_15;

import java.util.ArrayList;
import java.util.List;

/**
 * 可变参数与泛型
 * 
 * @author he
 * 
 */

public class P363 {
	private static <T> List<T> makeList(T... args) {
		List<T> result = new ArrayList<T>();
		for (T s : args) {
			result.add(s);
		}
		return result;
	}

	public static void main(String[] args) {
		List a = makeList("A", "B", 213, 44L);
		System.out.println(a);
		List b = makeList("A,S,D,F,G,H,J,K,L".split(","));
		System.out.println(b);
	}
}
