package Number_1502;
/**
 * ���������ͷ��ͷ���Ǳ�����ͻ���
 * @author he
 *
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class SimpleQueue<T> implements Iterable<T> {
	LinkedList<T> list = new LinkedList<T>();

	public void add(T item) {
		list.add(item);
	}

	public T get() {
		return list.poll();// ��ȡ���Ƴ��б�ĵ�һ��Ԫ��
	}

	public Iterator<T> iterator() {

		return list.iterator();
	}

}

// ��Ҫ�Ľӿ�
interface Addable<T> {
	void add(T t);
}

class Ax {
	@Override
	public String toString() {

		return getClass().getName().toString();
	}
}

class Bx extends Ax {
}

class SimpleQueueSon<T> extends SimpleQueue<T> implements Addable<T> {
	@Override
	public void add(T item) {
		super.add(item);
	}
}

/**
 * ��ײ����������
 * 
 * @author he
 *
 */

class AddableCollectionAdapter<T> implements Addable<T> {
	private Collection<T> collection;

	public AddableCollectionAdapter(Collection<T> collection) {
		this.collection = collection;
	}
	public void add(T t) {
		collection.add(t);
	}
}
/**
 * �����ṩ��̬��������
 * @author he
 *
 */
class Adapter{
	public static<T> Addable<T> collectionAdapter(Collection<T> c){
		return new AddableCollectionAdapter<T>(c);
	}
}



class Fill2 {
	// ���������Լ�����һЩ�ֻ࣬Ҫ��ʵ����Addalbe�ӿڣ���add�������о���ʹ�ø÷���������SimpleQueueSon
	public static <T> void fill(Addable<T> addable, Class<? extends T> class1Token, int size) {
		for (int i = 0; i < size; i++) {
			try {
				addable.add(class1Token.newInstance());// ��addable�����ʵ��
			} catch (Exception e) {
				throw new RuntimeException();// ��������쳣���׳�����ʱ�쳣
			}
		}
	}
}

public class P425 {
	public static void main(String[] args) {
		List<Ax> listA = new ArrayList<Ax>();
		 Fill2.fill(new AddableCollectionAdapter<Ax>(listA), Ax.class, 3);// û����
		 Fill2.fill(Adapter.collectionAdapter(listA), Bx.class, 2);// û����

		/**
		 * SimpleQueueSonʵ����Addable�ӿ���˿���ʹ��fill()����
		 */
		SimpleQueueSon<Ax> sq = new SimpleQueueSon<Ax>();
		 Fill2.fill(sq, Ax.class, 3);//û����
		 Fill2.fill(sq, Bx.class,2);//û����
		 for(Ax c:sq)
			 System.out.println(c);//
	}
}
