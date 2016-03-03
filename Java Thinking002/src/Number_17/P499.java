package Number_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * P499 œ∞Ã‚ 26
 * 
 * @author he
 * 
 */

class CountedString2 {
	String s;
	char c;
	int id;
	static List<String> list = new ArrayList<String>();

	CountedString2(String ss, char c1) {

		s = ss;
		c = c1;
		list.add(s);
		for (String s2 : list) {
			if (s2.equals(ss)) {

				id++;
			}
		}

	}

	@Override
	public int hashCode() {
		int result = 17;
		result = result * 37 + s.hashCode();
		result = result * 37 + c;
		result = result * 37 + id;

		return result;

	}

	@Override
	public boolean equals(Object obj) {

		return obj instanceof CountedString2
				&& s.equals(((CountedString2) obj).s)
				&& c == ((CountedString2) obj).c
				&& id == ((CountedString2) obj).id;
	}

	@Override
	public String toString() {

		return " String:" + s + "  Char:" + c + "  id:" + id + "  HashCode:"
				+ hashCode();
	}

}

public class P499 {
	public static void main(String[] args) {

		Map<CountedString2, Integer> map = new HashMap<CountedString2, Integer>();

		CountedString2 c[] = new CountedString2[5];
		for (int i = 0; i < c.length; i++) {
			c[i] = new CountedString2("A", 'a');
			map.put(c[i], i);
		}

		System.out.println(map);

		for (CountedString2 countedString : c) {
			System.out.println("Looking up " + countedString);

		}

	}
}
