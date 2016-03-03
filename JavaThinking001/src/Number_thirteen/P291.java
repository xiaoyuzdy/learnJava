package Number_thirteen;

import java.util.Formatter;

/**
 * 格式化说明符
 * 
 * @author he
 * 
 */
public class P291 {

	private double total = 0;
	private Formatter format = new Formatter(System.out);

	public void printfTitle() {
		format.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
		format.format("%-15s %5s %10s\n", "----", "---", "----");

	}

	public void print(String name, int qty, double price) {
		format.format("%-15.15s %5d %10.2f\n", name, qty, price);
		total += price;

	}

	public void printTotal() {
		format.format("%-15s %5s %10.2f\n", "Tax", "", total * 0.06);
		format.format("%-15s %5s %10s\n", "", "", "-----");
		format.format("%-15s %5s %10.2f\n", "Total", "", total * 1.06);
	}

	public static void main(String[] args) {

		P291 test = new P291();
		test.printfTitle();
		test.print("Jack's Magic Bean", 4, 4.25);
		test.print("Princess Peas", 3, 5.1);
		test.print("Three Bears Porridge", 1, 14.29);
		test.printTotal();

	}
}
