package Number_17;

/**
 *自定义Set ,hashSet,TreeSet 重写equals ，hashcode comparaTo方法
 */
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author he
 * 
 */

class SetType {
	int i;

	public SetType(int n) {
		i = n;
	}

	public boolean equals(Object obj) {

		return obj instanceof SetType && (i == ((SetType) obj).i);
	}

	public String toString() {
		return Integer.toString(i);
	}

}

class HashType extends SetType {

	public HashType(int n) {
		super(n);

	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}

class TreeType extends SetType implements Comparable<TreeType> {

	public TreeType(int n) {
		super(n);

	}

	public int compareTo(TreeType o) {

		return o.i < i ? -1 : (o.i == i) ? 0 : 1;
	}

}

class TypeforSet {
	public static <T> Set<T> fill(Set<T> set, Class<T> c) throws Exception {

		for (int i = 0; i < 10; i++) {
			set.add(c.getConstructor(int.class).newInstance(i));
		}

		return set;

	}

	public static <T> void test(Set<T> set, Class<T> c) throws Exception {
		fill(set, c);
		fill(set, c);
		fill(set, c);
		System.out.println(set);
	}

}

public class P478 {
	public static void main(String[] args) throws Exception {
		TypeforSet.test(new HashSet<HashType>(), HashType.class);
		System.out.println("-----------------");
		TypeforSet.test(new TreeSet<TreeType>(), TreeType.class);
		System.out.println("----------------");
		TypeforSet.test(new LinkedHashSet<HashType>(), HashType.class);
	}

}
