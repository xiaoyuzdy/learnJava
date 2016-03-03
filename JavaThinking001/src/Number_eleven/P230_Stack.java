package Number_eleven;

import java.util.LinkedList;

/**
 * linkedlist 能实现栈的所有功能 因此可以将linkedlist作为栈使用
 * 
 * linkedlst 能产生更好的stack
 * 
 * @author he
 * 
 */

public class P230_Stack<T> {
	private LinkedList<T> storage = new LinkedList<T>();

	// 添加栈顶元素
	public void push(T v) {
		storage.addFirst(v);

	}

	// 返回栈顶元素但不移除

	public void peek() {
		storage.getFirst();
	}

	// 返回栈顶元素 并移除

	public void pop() {
		storage.removeFirst();
	}

	// 判断是否为空
	public boolean empty() {
		return storage.isEmpty();
	}

	public String tosString() {
		return storage.toString();
	}

}
