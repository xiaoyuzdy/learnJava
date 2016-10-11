package N1;

import java.util.Map;

/**
 * P84 �ӿ�Map.Entry<K,V>�ĹǼ�ʵ���࣬�Ǽ�ʵ������Ϊ�˼̳ж���Ƶ�
 * 
 * @author he
 *
 */
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {

	/**
	 * ������ķ�����Ϊ�Ǽ�ʵ����ĳ��󷽷�
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
	 * ���������ṩ�����ʵ��
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
