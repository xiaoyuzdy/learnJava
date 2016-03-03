package Number_15;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 利用set 比较各个类的不同
 * 
 * @author he
 * 
 */

public class P368 {
	// 得到方法名
	public static Set<String> methodSet(Class<?> type) {
		Set<String> result = new TreeSet<String>();
		for (Method s : type.getMethods()) {
			result.add(s.getName());
		}
		return result;

	}

	// 移除A包含B的部分
	static <T> Set<T> difference(Set<T> A, Set<T> B) {
		Set<T> result = new HashSet<T>(A);
		result.removeAll(B);
		return result;

	}

	static void differenceSet(Class<?> A, Class<?> B) {
		Set<String> set = difference(methodSet(A), methodSet(B));
		// 移除Object的方法
		set.remove(methodSet(Object.class));
		System.out.println(set);

	}

	public static void main(String[] args) {
		System.out.println(methodSet(Set.class));
		differenceSet(TreeSet.class, HashSet.class);
		differenceSet(TreeMap.class, Map.class);
	}
}
