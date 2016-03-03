package Number_17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * δ��֧�ֵĲ��� ��ΪArrays.asList ���ص���һ���̶���С��List 
 * ��˶��ڸı����С�ķ�������δ֧�ֵ�
 * 
 * @author he
 * 
 */

public class P473 {
	public static void test(String mes, Collection<String> list) {
		System.out.println("------------" + mes + "----------");

		try {
			list.add("1");
			list.remove("A");
			list.clear();
		} catch (Exception e) {
			System.out.println(" " + e);
		}

		System.out.println(list.size());
		
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("A B C D E F G".split(" "));
		test("Arrays.asList", list);
		test("222", new ArrayList<String>(list));
	}

}
