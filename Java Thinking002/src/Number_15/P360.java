package Number_15;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 通过继承实现适配器
 * 
 * @author he
 * 
 */

class Fibonacci {
	private int count = 0;

	public Integer next() {
		return fib(count++);
	}

	private int fib(int n) {
		if (n < 2)
			return 1;
		return fib(n - 2) + fib(n - 1);
	}

}

public class P360 extends Fibonacci implements Iterable<Integer> {

	private int n;

	public P360(int count) {
		n = count;
	}

	public Iterator<Integer> iterator() {

		return new Iterator<Integer>() {

			public boolean hasNext() {

				return n > 0;
			}

			public Integer next() {
				n--;
				return P360.this.next();
			}

			public void remove() {
				throw new UnsupportedOperationException();

			}

		};

	}

	public static void main(String[] args) {
		for (int i : new P360(18)) {
			System.out.println(i);
		}
	}

}
