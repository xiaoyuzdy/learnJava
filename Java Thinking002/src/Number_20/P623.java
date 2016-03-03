package Number_20;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 注释处理器
 * 
 * @author he
 *
 */
public class P623 {
	static void trackUseCases(List<Integer> useCase, Class<?> c) {
		for (Method m : c.getDeclaredMethods()) {
			// 返回此元素的所有注释
			UseCase uc = m.getAnnotation(UseCase.class);

			if (uc != null) {
				System.out.println("id=" + uc.id() + " descr=" + uc.description());
				useCase.remove(new Integer(uc.id()));
			}

		}

		for (Integer i : useCase) {
			System.out.println("Warning : Missing use case -" + i);
		}
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, 47, 48, 49);
		trackUseCases(list, P622.class);
	}

}
