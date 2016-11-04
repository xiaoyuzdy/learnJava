package Number_19;

import java.util.Random;

/**
 * P596
 * Ëæ»úÑ¡È¡
 * 
 * @author he
 * 
 */
public class Enums {
	
	private static Random rand = new Random(47);

	public static <T extends Enum<T>> T random(Class<T> c) {
		return random(c.getEnumConstants());

	}

	public static <T> T random(T[] values) {
		return values[rand.nextInt(values.length)];

	}

}
