package N1;

import java.util.HashMap;
import java.util.Map;

/**
 * ������ ����Object��ͨ�÷�����equals��hashCode��toString�� ��дequalsͬʱҲҪ������дhashCode����
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
	 * ��д��������equals�����ľ��ϣ� 1��ʹ�á�==���������Ƿ�Ϊ�����������ã����==�Ƚ�Ϊtrue����equalsһ��Ϊtrue
	 * 2��ʹ��instanceof�������ͼ�� 3����������2������£�������ת��Ϊ��ȷ������
	 * 4���������equalsҪ�������ĳ�Ա�����͸ö���ĳ�Ա�����Ƿ���ͬ��ע�����float,
	 * double���͵ı���Ҫʹ�����ǰ�װ���compare�������бȽ� 5��д��equals������һ��Ҫ����Ƿ����㣬�Գ��ԣ��������Լ�һ����
	 * ��Ҫ��equals�����Ĳ���Object�����滻Ϊ�������� public boolean equals(Object o){...}
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
	 * ָ�����toString��ʽ
	 */
	@Override
	public String toString() {
		return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
	}

	/**
	 * ��Ҫ��clone�������������� ���Ҫʹ����clone����Ҫ��ʵ��Cloneable�ӿڣ������׳��쳣
	 * ���������һ����final���е�clone��������Ӧ�÷���һ��ͨ������super.clone���õ��Ķ���
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
		System.out.println(m.get(new phoneNumber(1, 2, 3)));// �������дhashCode����null
		System.out.println(new phoneNumber(1, 2, 3).toString());

	}

}
