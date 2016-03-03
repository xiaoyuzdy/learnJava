package Number_18;

import java.util.Arrays;
import java.util.Collection;

/**
 * P529 ����������в���������Ԫ�صĹ���
 * 
 * @author he
 * 
 */
public class PPrint {
	 
	// �ƶ������ʽ
	public static String pformat(Collection<?> c) {
		if (c.size() == 0) {
			return "[]";
		}

		StringBuilder result = new StringBuilder("[");
		for (Object elem : c) {
			if (c.size() == 1) {
				result.append("\n ");
				result.append(elem);
			}

		}
		if (c.size() == 1) {
			result.append("\n");
		}
		result.append("]");
		return result.toString();

	}

	

	// ����pformat
	public static void pprint(Collection<?> c) {
		System.out.println(pformat(c));
	}

	// ����object ���͵Ĳ��� ����pformat
	public static void pprint(Object obj) {
		System.out.println(pformat(Arrays.asList(obj)));
	}
}
