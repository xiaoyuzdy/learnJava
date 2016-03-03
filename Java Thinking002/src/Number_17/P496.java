package Number_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 例题
 * 
 * @author he
 * 
 */
class CountedString {
	private String s;
	private int id = 0;

	private static List<String> list = new ArrayList<String>();

	CountedString(String string) {
		s = string;
		list.add(s);
		// 如果s重复则id++
		for (String s2 : list) {
			if (s2.equals(s)) {
				id++;
			}
		}

	}

	@Override
	public String toString() {

		return "String: " + s + " Id: " + id + " HashCode: " + hashCode();
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 37 * result + s.hashCode();
		result = 37 * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		return obj instanceof CountedString
				&& s.equals(((CountedString) obj).s)
				&& id == ((CountedString) obj).id;
	}
}

public class P496 {
	public static void main(String[] args) {
		Map<CountedString, Integer> map = new HashMap<CountedString, Integer>();
		CountedString[] cs = new CountedString[5];
		for (int i = 0; i < 5; i++) {
			cs[i] = new CountedString("hi");
			map.put(cs[i], i);
		}
		System.out.println(map);

		for (CountedString count : cs) {
			System.out.println("Looking up " + count);
			System.out.println(map.get(count));

		}

	}
}
