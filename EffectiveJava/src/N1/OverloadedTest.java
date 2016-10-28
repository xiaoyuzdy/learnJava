package N1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * P167
 * 
 * @author he
 *
 */
public class OverloadedTest {

	// 可变参数，每个参数的类型都是int型
	static int sum(int... args) {
		int sum = 0;
		for (int t : args)
			sum += t;
		return sum;
	}

	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = -3; i < 3; i++) {
			set.add(i);
			list.add(i);
		}

		/**
		 * 期望结果：set和list移除所有的正整数 实际结果：set的结果与期望结果相符，原因使用的是 set.remove(E)
		 * 而list中有两种方法list.remove(int index)和list.remove(Object o),
		 * 由于包装类的缘故会选择remove(int index)方法，会根据下标移除元素，导致与期望不符合
		 */
		for (int i = 0; i < 3; i++) {
			set.remove(i);
			list.remove(i);
			// 应改为
			// list.remove(Integer.valueOf(i));
		}

		System.out.println(set + "   " + list);
		System.out.println(sum(1, 2, 3, 4));

	}

}
