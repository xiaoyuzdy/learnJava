package Number_16Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 创建泛型数组的引用 再创建没泛型数组然后将其转型
 * 
 * @author he
 * 
 */
public class P441 {
	static List<String> ls[];
	static List[] la = new List[2];

	public static void main(String[] args) {
		// 可以通过
		// la[0] = new ArrayList<Integer>();
		ls = la;
		ls[0] = new ArrayList<String>();
		ls[0].add("1");
		// Type mismatch: cannot convert from ArrayList<Integer> to List<String>
		// 编译通不过
		// ls[1]=new ArrayList<Integer>();

		// 因为数组是协变的，所以 List<String>[] 也是Object[]类型
		Object[] obj = ls;

		obj[1] = new ArrayList<Integer>();
		System.out.println(Arrays.toString(obj));
	}
}
