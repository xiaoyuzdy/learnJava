package N1;
/**
 * P118
 */
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

public class GenericStack<E> {
	private E elements[];
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;// Ĭ�����ݴ�С

	@SuppressWarnings("unchecked")
	public GenericStack() {
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public E pop() {
		if (size == 0)
			throw new EmptyStackException();

		/**
		 * �����ôд������ᱣ�����Ѿ�����ȥ��Ԫ�ص����ã��������ǹ������ã������������鲻��������С�ᷢ��memory leak���ڴ�й©��
		 */

		// return elements[--size];

		/**
		 * Ҫ��������������Ҫ����д
		 */

		E result = elements[--size];
		elements[size] = null;// ������������
		return result;

	}

	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, size * 2 + 1);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void pushAll(Iterable<? extends E> src) {
		for (E e : src)
			push(e);
	}

	public void popAll(Collection<? super E> dst) {
		while (isEmpty()) {
			dst.add(pop());
		}
	}

}
