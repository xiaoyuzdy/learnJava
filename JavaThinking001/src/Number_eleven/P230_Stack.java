package Number_eleven;

import java.util.LinkedList;

/**
 * linkedlist ��ʵ��ջ�����й��� ��˿��Խ�linkedlist��Ϊջʹ��
 * 
 * linkedlst �ܲ������õ�stack
 * 
 * @author he
 * 
 */

public class P230_Stack<T> {
	private LinkedList<T> storage = new LinkedList<T>();

	// ���ջ��Ԫ��
	public void push(T v) {
		storage.addFirst(v);

	}

	// ����ջ��Ԫ�ص����Ƴ�

	public void peek() {
		storage.getFirst();
	}

	// ����ջ��Ԫ�� ���Ƴ�

	public void pop() {
		storage.removeFirst();
	}

	// �ж��Ƿ�Ϊ��
	public boolean empty() {
		return storage.isEmpty();
	}

	public String tosString() {
		return storage.toString();
	}

}
