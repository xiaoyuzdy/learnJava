package N1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * P234
 * 
 * @author he
 *
 */

class ForwardingSet<E> implements Set<E> {
	private final Set<E> s;

	public ForwardingSet(Set<E> s) {
		this.s = s;
	}

	@Override
	public int size() {
		return s.size();
	}

	@Override
	public boolean isEmpty() {
		return s.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return s.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return s.iterator();
	}

	@Override
	public Object[] toArray() {
		return s.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return s.toArray(a);
	}

	@Override
	public boolean add(E e) {
		return s.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return s.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return s.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return s.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return s.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return s.removeAll(c);
	}

	@Override
	public void clear() {
		s.clear();
	}

}

/**
 * �ص��ӿ�
 * 
 * @author he
 *
 * @param <E>
 */
interface SetObserver<E> {
	void added(ObservableSet<E> set, E element);
}

public class ObservableSet<E> extends ForwardingSet<E> {
	private final List<SetObserver<E>> observers = new ArrayList<SetObserver<E>>();

	public ObservableSet(Set<E> s) {
		super(s);
	}

	public void addObserver(SetObserver<E> observer) {
		synchronized (observers) {
			observers.add(observer);
		}
	}

	public void removeObserver(SetObserver<E> observer) {
		synchronized (observers) {
			observers.remove(observer);
		}
	}

	private void notifyElementAdded(E element) {
		synchronized (observers) {
			for (SetObserver<E> observer : observers) {
				observer.added(this, element);// ͬ�������е��ñ����Ϊ��д����������
			}
		}
	}

	/**
	 * ������ķ�����Ϊ����ķ�������,ʹ�ÿ��ŵ���
	 * 
	 * @param element
	 */
//	private void notifyElementAdded(E element) {
//		List<SetObserver<E>> snapshot = null;
//		synchronized (observers) {
//			snapshot = new ArrayList<SetObserver<E>>(observers);
//		}
//
//		for (SetObserver<E> observer : snapshot)
//			observer.added(this, element);
//
//	}

	@Override
	public boolean add(E element) {
		boolean added = super.add(element);
		if (added)
			notifyElementAdded(element);
		return added;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean result = false;
		for (E element : c)
			result |= add(element);
		return result;
	}

	public static void main(String[] args) {
		ObservableSet<Integer> set = new ObservableSet<>(new HashSet<Integer>());
		set.addObserver(new SetObserver<Integer>() {
			@Override
			public void added(ObservableSet<Integer> set, Integer element) {
				System.out.println(element);
				// ���׳��쳣����ͼ�ڱ��������б��ʱ�򣬽�һ��Ԫ�ش��б���ɾ�������ǷǷ��Ĳ���
				if (element == 23)
					set.removeObserver(this);
			}
		});

		for (int i = 0; i < 100; i++)
			set.add(i);

	}

}
