package Number_eleven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * ��������ʹ��
 * 
 * ��foreach�õ���ǰ�ĵ����� 
 * ͨ���Լ��ķ����õ����ĵ�����
 * 
 * @author he
 * 
 * @param <T>
 */

class Myarraylist<T> extends ArrayList<T> {
	public Myarraylist(Collection<T> c) {
		super(c);
	}

	// �������������
	public Iterable<T> reversed() {
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return new Iterator<T>() {

					int count = size() - 1;

					public boolean hasNext() {

						return count > -1;

					}

					public T next() {
						return get(count--);
					}

					public void remove() {
						throw new UnsupportedOperationException();

					}

				};

			}

		};

	}

}

public class P243_shi_pei_qi {

	public static void main(String[] args) {
		Myarraylist<String> ml = new Myarraylist<String>(
				Arrays.asList("a,b,c,d,e,f,g".split(",")));

		for (String s : ml) {
			System.out.print(s + " ");
		}
		System.out.println("\n");

		for (String s1 : ml.reversed()) {
			System.out.print(s1 + " ");
		}

	}

}
