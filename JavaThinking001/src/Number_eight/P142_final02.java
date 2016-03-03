package Number_eight;

/**
 * 
 * @author he
 * 
 */
public class P142_final02 {

	final private int a;

	public P142_final02(int x) {
		a = x;
		// index++;

	}

	public int toInteger() {

		return a;

	}

	public static void main(String[] args) {

		P142_final02 w = new P142_final02(3);

		System.out.println("number-->" + w.toInteger());

		System.out.println("\n---------");
		P142_final02 w2 = new P142_final02(10);

		System.out.println("number-->" + w2.toInteger());

	}

}
