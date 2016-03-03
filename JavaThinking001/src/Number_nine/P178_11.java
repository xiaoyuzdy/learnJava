package Number_nine;

public class P178_11 {
	static String swap(String s) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < sb.length() - 1; i += 2) {
			char c1 = sb.charAt(i);
			char c2 = sb.charAt(i + 1);

			sb.setCharAt(i, c2);
			sb.setCharAt(i + 1, c1);

		}
		System.out.println(sb.toString());
		return null;
	}

	public static void main(String[] args) {
		
		P178_11.swap("1234");
	}
}
