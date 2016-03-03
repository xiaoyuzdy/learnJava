package Number_17;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Á·Ï°7
 * 
 * @author he
 * 
 */

public class P477 {

	public static void iter(List<String> list) {
		Iterator<String> ite = list.iterator();
		while (ite.hasNext()) {
			System.out.print(ite.next());
		}
		System.out.println("\n----------------------");
		ListIterator<String> ls = list.listIterator();

		ls.set(ls.next());
		ls.add(ls.next());
		while (ls.hasNext()) {

			System.out.print(ls.next());
		}

	}

	public static void main(String[] args) {
		String[] st = "A B C D E".split(" ");
		List<String> list = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		for (String str : st) {
			list.add(str);
			list2.add(str);
		}

		System.out.println("ArraysList----------");
		iter(list);
		System.out.println("LinkedList----------");
		iter(list2);

	}

}
