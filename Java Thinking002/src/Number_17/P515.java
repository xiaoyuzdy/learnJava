package Number_17;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 习题 40
 * 
 * @author he
 * 
 */
class TwoString implements Comparable<TwoString> {
	String s1;
	String s2;

	TwoString(String s11, String s22) {
		s1 = s11;
		s2 = s22;
	}

	@Override
	public String toString() {

		return "s1 :" + s1 + "  s2 :" + s2;

	}

	// 按s1的大小排序
	public int compareTo(TwoString string) {

		String s13 = string.s1;
		return s1.compareTo(s13);
	}

	public int compareTo(TwoString str1, TwoString str2) {

		return str1.s2.compareTo(str2.s2);

	}

}

// 按s2的大小排序
class SecondCompare implements Comparator<TwoString> {
	public int compare(TwoString str1, TwoString str2) {

		return str1.s2.compareTo(str2.s2);

	}
}

public class P515 {
	public static void main(String[] args) {
		TwoString[] a = new TwoString[3];
		a[0] = new TwoString("1", "c");
		a[1] = new TwoString("3", "a");
		a[2] = new TwoString("2", "d");
		// 按s1的大小排序
		Arrays.sort(a);

		for (TwoString a1 : a) {
			System.out.println(a1);
		}
		System.out.println("----------------------------");

		// 按s2的大小排序
		Arrays.sort(a, new SecondCompare());

		for (TwoString a1 : a) {
			System.out.println(a1);
		}

	}
}
