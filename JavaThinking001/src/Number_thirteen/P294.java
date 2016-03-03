package Number_thirteen;

/**
 * 十六进制转储工具
 * 
 * @author he
 * 
 */
public class P294 {
	public static String format(Byte[] a) {

		StringBuilder result = new StringBuilder();
		int n = 0;
		for (byte b : a) {
			if (n % 16 == 0) {
				result.append(String.format("%05X", n));
			}

			result.append(String.format("%02X", b));
			n++;
			if (n % 16 == 0) {
				result.append("\n");

			}

		}
		result.append("\n");
		return result.toString();

	}

	public static void main(String[] args) {
		Byte[] a = new Byte[] { 111, 99, 22, 44, 55, 66, 77, 88, 14, 33, 44,
				43, 25, 65, 34, 124, 54, 35, 24, 45, 4, 3, 5, 6, 32, 56, 76,
				76, 87 };

		System.out.println(format(a));
	}

}
