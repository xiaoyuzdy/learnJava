package N1;

import java.util.HashMap;
import java.util.Map;

/**
 * P124 �칹����
 * 
 * @author he
 *
 */

class Favorites {
	// Map��key�ǲ�������ʹ�õ���������ͨ��� ?�����Map�п������Ԫ��
	private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();

	/**
	 * typeΪ�������� ����д�� Map�еļ���ֵ������û�ж��ڹ�ϵ�����ܱ�֤ÿ��ֵ�����Ͷ��Ǽ�������
	 * �����ΪString���ͣ�ֵΪ1,������������ȡ��Ԫ��ʱ��������ת���쳣��java.lang.ClassCastException ����취������
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
	 * �����޷���key��value���Ͳ�ͬ�������ӵ�������
	 * 
	 * @param type
	 * @param instance
	 */
	public <T> void putFavorite2(Class<?> type, T instance) {
		if (type == null) {
			throw new NullPointerException("type is null");
		}
		favorites.put(type, type.cast(instance));// �������ת������ֱ���׳��쳣
	}

	public <T> T getFavorite(Class<T> type) {
		return type.cast(favorites.get(type));// ��Object����̬��ת������Class��������ʾ������
	}

}

public class HeterogeneousContainer {
	public static void main(String[] args) {
		Favorites f = new Favorites();
		f.putFavorite(Integer.class, 1);
		f.putFavorite(Character.class, 'A');
		f.putFavorite(Class.class, Favorites.class);
		f.putFavorite(String.class, 1);// ����ֵ�����Ͳ�ͬ���������
		f.putFavorite(String[].class, new String[] { "A", "B" });
		// f.putFavorite2(String.class, 1);//������ת���쳣��ֹ�������ʱ
		System.out.println(f.getFavorite(Character.class));// A
		System.out.println(f.getFavorite(String[].class));// �����ڴ��ַ��[Ljava.lang.String;@4e25154f
		// System.out.println(f.getFavorite(String.class));//java.lang.ClassCastException
		// f.putFavorite(List<Sting>.class, newArrayList<String>());//�޷���ӣ���ΪList<String>.class�﷨����

	}
}
