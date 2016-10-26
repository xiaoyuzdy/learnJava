package N1;

import java.util.HashMap;
import java.util.Map;

/**
 * P124 异构容器
 * 
 * @author he
 *
 */

class Favorites {
	// Map的key是参数化的使用的是无限制通配符 ?，因此Map中可以添加元素
	private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();

	/**
	 * type为类型令牌 这种写法 Map中的键和值的类型没有对于关系，不能保证每个值的类型都是键的类型
	 * 比如键为String类型，值为1,这样将导致在取出元素时出现类型转换异常，java.lang.ClassCastException 解决办法见方法
	 * putFavorite2
	 * 
	 * @param type
	 * @param instance
	 */
	public <T> void putFavorite(Class<?> type, T instance) {
		if (type == null) {
			throw new NullPointerException("type is null");
		}
		favorites.put(type, instance);
	}

	/**
	 * 这样无法将key和value类型不同的情况添加到容器中
	 * 
	 * @param type
	 * @param instance
	 */
	public <T> void putFavorite2(Class<?> type, T instance) {
		if (type == null) {
			throw new NullPointerException("type is null");
		}
		favorites.put(type, type.cast(instance));// 如果类型转换错误，直接抛出异常
	}

	public <T> T getFavorite(Class<T> type) {
		return type.cast(favorites.get(type));// 将Object对象动态的转换成了Class对象所表示的类型
	}

}

public class HeterogeneousContainer {
	public static void main(String[] args) {
		Favorites f = new Favorites();
		f.putFavorite(Integer.class, 1);
		f.putFavorite(Character.class, 'A');
		f.putFavorite(Class.class, Favorites.class);
		f.putFavorite(String.class, 1);// 键和值的类型不同，可以添加
		f.putFavorite(String[].class, new String[] { "A", "B" });
		// f.putFavorite2(String.class, 1);//将类型转换异常阻止在了添加时
		System.out.println(f.getFavorite(Character.class));// A
		System.out.println(f.getFavorite(String[].class));// 返回内存地址，[Ljava.lang.String;@4e25154f
		// System.out.println(f.getFavorite(String.class));//java.lang.ClassCastException
		// f.putFavorite(List<Sting>.class, newArrayList<String>());//无法添加，因为List<String>.class语法错误

	}
}
