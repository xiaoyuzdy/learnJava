package N1;

import java.util.HashMap;
import java.util.Map;

/**
 * 第三章 覆盖Object的通用方法，equals、hashCode、toString， 重写equals同时也要必须重写hashCode方法
 * 
 * @author he
 *
 */
public final class phoneNumber implements Cloneable, Comparable {
	private final int areaCode;
	private final int prefix;
	private final int lineNumber;

	public phoneNumber(int areaCode, int prefix, int lineNumber) {
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNumber = lineNumber;
	}

	/**
	 * 编写高质量的equals方法的诀窍： 1、使用“==”检查操作是否为这个对象的引用，如果==比较为true，则equals一定为true
	 * 2、使用instanceof进行类型检查 3、满足条件2的情况下，将参数转化为正确的类型
	 * 4、对于类的equals要检查参数的成员变量和该对象的成员变量是否相同，注意对于float,
	 * double类型的变量要使用它们包装类的compare方法进行比较 5、写完equals方法后一定要检查是否满足，对称性，传递性以及一致性
	 * 不要把equals方法的参数Object类型替换为其他类型 public boolean equals(Object o){...}
	 */

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof phoneNumber))
			return false;
		phoneNumber o = (phoneNumber) obj;
		return o.areaCode == areaCode && o.prefix == prefix && o.lineNumber == lineNumber;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = result * 31 + areaCode;
		result = result * 31 + prefix;
		result = result * 31 + lineNumber;
		return result;
	}

	/**
	 * 指定类的toString格式
	 */
	@Override
	public String toString() {
		return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
	}

	/**
	 * 不要用clone方法！！！！！ 如果要使用类clone方法要先实现Cloneable接口，否则抛出异常
	 * 如果覆盖了一个非final类中的clone方法，则应该返回一个通过调用super.clone而得到的对象
	 * 
	 */
	@Override
	protected phoneNumber clone() throws CloneNotSupportedException {
		return (phoneNumber) super.clone();
	}

	@Override
	public int compareTo(Object o) {
		phoneNumber t = (phoneNumber) o;
		if (areaCode < t.areaCode)
			return -1;
		if (areaCode > t.areaCode)
			return 1;
		if (prefix < t.prefix)
			return -1;
		if (prefix > t.prefix)
			return 1;
		if (lineNumber < t.lineNumber)
			return -1;
		if (lineNumber > t.lineNumber)
			return 1;
		return 0;
	}

	public static void main(String[] args) {
		Map<phoneNumber, Integer> m = new HashMap<phoneNumber, Integer>();
		m.put(new phoneNumber(1, 2, 3), 10);
		System.out.println(m.get(new phoneNumber(1, 2, 3)));// 如果不重写hashCode返回null
		System.out.println(new phoneNumber(1, 2, 3).toString());

	}

}
