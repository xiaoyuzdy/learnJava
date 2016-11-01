package Number_19;

import java.util.Random;

/**
 * P598
 * 
 * @author he
 *
 */

interface Fruit {
	enum Apple implements Fruit {
		GREEN_APPLE, RED_APPLE
	}

	enum Grape implements Fruit {
		RED_GRAPE, VIOLET_GRAPE
	}
}

enum Course2 {
	Apple(Fruit.Apple.class), Grape(Fruit.Grape.class);
	private Fruit[] values;

	private Course2(Class<? extends Fruit> kind) {
		values = kind.getEnumConstants();
	}

	// ²úÉúËæ»úFruit
	public Fruit randomSelection() {
		return values[new Random().nextInt(values.length)];
	}
}

public class P598 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (Course2 course : Course2.values()) {
				Fruit fruit = course.randomSelection();
				System.out.println(fruit);
			}
			System.out.println("------------");
		}
	}

}
