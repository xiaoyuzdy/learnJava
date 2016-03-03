package Number_15;

import java.util.HashMap;
import java.util.Map;

/**
 * Á·Ï° 21
 * 
 * @author he
 * 
 */
public class P381 {
	static Map<String, Class<?>> map = new HashMap<String, Class<?>>();

	public static void addType(String typename, Class<?> kind) {
		map.put(typename, kind);
	}

	public static Object createNew(String typeName)
			throws InstantiationException, IllegalAccessException {
		Class<?> c1 = map.get(typeName);
		return c1.newInstance();

	}

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException {
		addType("HashMap", HashMap.class);
		System.out.println(createNew("HashMap").getClass());
	}
}
