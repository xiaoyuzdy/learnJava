package Number_16Arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * 返回一个数组
 * 
 * @author he
 * 
 */
public class P436 {

	static Random rand = new Random(47);
	static String[] str = { "酸", "甜", "苦", "辣", "香" };

	public static String[] flavorSet(int n) {

		String[] result = new String[n];
		boolean[] b = new boolean[str.length];
		for (int i = 0; i < n; i++) {
			int t;
			do {
				t = rand.nextInt(str.length);

			} while (b[t]);
			result[i] = str[t];

		}

		return result;

	}

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			System.out.println(Arrays.toString(flavorSet(4)));
		}

	}

}
