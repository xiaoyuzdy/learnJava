package Number_15;

import java.lang.reflect.Array;

class GenericArray<T> {
	private T array[];
	private int count;

	// �ڹ�����������������ͣ��Ա�Ӳ����лָ����������Եõ�һ����������
	public GenericArray(Class<T> c, int N) {
		array = (T[]) Array.newInstance(c, N);
	}

	public void put(T item) {
		array[count++] = item;
		count++;
	}

	public T get(int index) {
		return array[index];
	}

	public T[] pre() {
		return array;
	}

}

public class P386 {
	public static void main(String[] args) {
		GenericArray<Integer> g = new GenericArray<Integer>(Integer.class, 10);
		g.put(1);
		System.out.println("xxx");
		Integer[] tt = g.pre();// ������
	}
}
