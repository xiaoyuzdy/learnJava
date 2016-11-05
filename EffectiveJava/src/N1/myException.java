package N1;

/**
 * P224
 * @author he
 *
 */
class MyIndexOutOfBoundsException extends IndexOutOfBoundsException {
	private int lowerBound;
	private int upperBound;
	private int index;

	public MyIndexOutOfBoundsException(int lowerBound, int index, int upperBound) {
		super("Lower bound: " + lowerBound + ", Upper bound: " + upperBound + ", Index: " + index);
		this.lowerBound = lowerBound;
		this.index = index;
		this.upperBound = upperBound;
	}

}

public class myException {
	private static final int a[] = new int[3];

	private static void add(int index, int item) {
		if (index < 0 || index > 2)
			throw new MyIndexOutOfBoundsException(0, index, 2);
		a[index] = item;
	}

	public static void main(String[] args) {
		add(0, 1);
		add(3, 10);
	}

	/**
	 * ½á¹û£º Exception in thread "main" Num_6.MyIndexOutOfBoundsException: 
	 * Lower bound: 0, Upper bound: 2, Index: 3
	 * 
	 */
}
