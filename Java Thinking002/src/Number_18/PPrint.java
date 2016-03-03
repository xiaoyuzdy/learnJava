package Number_18;

import java.util.Arrays;
import java.util.Collection;

/**
 * P529 可以添加新行并缩排所有元素的工具
 * 
 * @author he
 * 
 */
public class PPrint {
	 
	// 制定输出格式
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

	

	// 调用pformat
	public static void pprint(Collection<?> c) {
		System.out.println(pformat(c));
	}

	// 对于object 类型的参数 调用pformat
	public static void pprint(Object obj) {
		System.out.println(pformat(Arrays.asList(obj)));
	}
}
