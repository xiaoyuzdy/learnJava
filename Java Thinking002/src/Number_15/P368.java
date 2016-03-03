package Number_15;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * ����set �Ƚϸ�����Ĳ�ͬ
 * 
 * @author he
 * 
 */

public class P368 {
	// �õ�������
	public static Set<String> methodSet(Class<?> type) {
		Set<String> result = new TreeSet<String>();
		for (Method s : type.getMethods()) {
			result.add(s.getName());
		}
		return result;

	}

	// �Ƴ�A����B�Ĳ���
	static <T> Set<T> difference(Set<T> A, Set<T> B) {
		Set<T> result = new HashSet<T>(A);
		result.removeAll(B);
		return result;

	}

	static void differenceSet(Class<?> A, Class<?> B) {
		Set<String> set = difference(methodSet(A), methodSet(B));
		// �Ƴ�Object�ķ���
		set.remove(methodSet(Object.class));
		System.out.println(set);

	}

	public static void main(String[] args) {
		System.out.println(methodSet(Set.class));
		differenceSet(TreeSet.class, HashSet.class);
		differenceSet(TreeMap.class, Map.class);
	}
}
