package Number_1502;

import java.util.ArrayList;
import java.util.List;

/**
 * �߽缰ͨ���
 * 
 * extends �Ͻ� super �½�
 * 
 * @author he
 * 
 */

class Fruit {
}

class Apple extends Fruit {
};

class Apple2 extends Apple {
}

// ������ͨ���
class GenericWriting {
	static List<Apple> list1 = new ArrayList<Apple>();
	static List<Fruit> list2 = new ArrayList<Fruit>();

	public <T> void writeWithWlidcard(List<? super T> list, T item) {
		list.add(item);
	}

	public void f() {
		// T ΪApple �������ӱ��� �����������లȫ��
		writeWithWlidcard(list1, new Apple());
		// �������޷��жϣ�super Apple �Ƿ�ȫ �� ����������
		// writeWithWlidcard(list1, new Fruit());
		// T ΪFruit �������������
		writeWithWlidcard(list2, new Apple());
	}

}

public class P391 {
	static void write(List<? super Apple> list2) {
		// AppleΪ�½� ������������ǰ�ȫ�� �����Կ���add������������

		list2.add(new Apple2());// OK
		// �������޷����Apple ����İ�ȫ�� �����޷�����
		// list2.add(new Fruit());

	}

	static void write2(List<? extends Apple> list) {
		// add() ��Ĳ���Ϊ �� extends Apple2
		// �������޷���ⰲȫ�� ����޷�ͨ������
		// list.add(new Apple2());
	}

	public static void main(String[] args) {
		// List<? extends Number> list = new ArrayList<Integer>();
		// list.add(0, null);
		// ������
		// list.add(1,3.f);
		// System.out.println(list.get(0));

	}
}
