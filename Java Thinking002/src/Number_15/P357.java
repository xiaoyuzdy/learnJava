package Number_15;

/**
 * 自己定义一个栈
 * 不用linklist写
 * 
 * @author he
 * 
 */
public class P357<T> {
	private static class Node<U> {
		U item;
		Node<U> next;

		public Node() {
			item = null;
			next = null;
		}

		Node(U item, Node<U> next) {
			this.item = item;
			this.next = next;
		}

		boolean end() {

			return item == null && next == null;
		}

	}

	private Node<T> top = new Node<T>();

	public void push(T item) {
		top = new Node<T>(item, top);
	}

	public T pop() {
		T result = top.item;
		if (!top.end()) {
			top = top.next;
		}
		return result;
	}

	public static void main(String[] args) {
		P357<String> stack = new P357<String>();
		for (String s : "Phasers on stun!".split(" ")) {
			stack.push(s);
		}
		String s;
		while ((s = stack.pop()) != null) {
			System.out.println(s);
		}

	}

}
