package N1;

import java.util.HashMap;
import java.util.Map;

/**
 * ������ ����Object��ͨ�÷�����equals��hashCode��toString�� ��дequalsͬʱҲҪ������дhashCode����
 * 
 * @author he
 *
 */
public final class phoneNumber {
	private final int areaCode;
	private final int prefix;
	private final int lineNumber;

	public phoneNumber(int areaCode, int prefix, int lineNumber) {
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNumber = lineNumber;
	}

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

	public static void main(String[] args) {
		Map<phoneNumber, Integer> m = new HashMap<phoneNumber, Integer>();
		m.put(new phoneNumber(1, 2, 3), 10);
		System.out.println(m.get(new phoneNumber(1, 2, 3)));// �������дhashCode����null

	}

}
