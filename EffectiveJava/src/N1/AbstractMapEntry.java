package N1;

import java.util.Map;

/**
 * P84 接口Map.Entry<K,V>的骨架实现类，骨架实现类是为了继承而设计的
 * 
 * @author he
 *
 */
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {

	/**
	 * 最基本的方法成为骨架实现类的抽象方法
	 */
	public abstract K getKey();

	public abstract V getValue();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Map.Entry))
			return false;

		Map.Entry<?, ?> arg = (Map.Entry) obj;

		return equals(getKey(), arg.getKey()) && equals(getValue(), arg.getValue());

	}

	/**
	 * 其他方法提供具体的实现
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */

	private boolean equals(Object o1, Object o2) {
		return o1 == null ? o2 == null : o1.equals(o2);
	}

	@Override
	public int hashCode() {
		return hashCode(getKey()) ^ hashCode(getValue());
	}

	private int hashCode(Object o) {
		return o == null ? 0 : o.hashCode();
	}

}
