package N1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * P167
 * 
 * @author he
 *
 */
public class OverloadedTest {

	// �ɱ������ÿ�����������Ͷ���int��
	static int sum(int... args) {
		int sum = 0;
		for (int t : args)
			sum += t;
		return sum;
	}

	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = -3; i < 3; i++) {
			set.add(i);
			list.add(i);
		}

		/**
		 * ���������set��list�Ƴ����е������� ʵ�ʽ����set�Ľ����������������ԭ��ʹ�õ��� set.remove(E)
		 * ��list�������ַ���list.remove(int index)��list.remove(Object o),
		 * ���ڰ�װ���Ե�ʻ�ѡ��remove(int index)������������±��Ƴ�Ԫ�أ�����������������
		 */
		for (int i = 0; i < 3; i++) {
			set.remove(i);
			list.remove(i);
			// Ӧ��Ϊ
			// list.remove(Integer.valueOf(i));
		}

		System.out.println(set + "   " + list);
		System.out.println(sum(1, 2, 3, 4));

	}

}
