package Number_eleven;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 统计数字重复的次数
 * 
 * @author he
 * 
 */
public class P234 {

	public static void main(String[] args) {
		Random rand = new Random(47);

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < 1000; i++) {

			int r = rand.nextInt(20);

			Integer in = map.get(r);

			// 如果map.get(r)为空in为1 否则 in=map.get(r)+1

			map.put(r, in == null ? 1 : map.get(r) + 1);

		}

		System.out.println(map);

	}

}
