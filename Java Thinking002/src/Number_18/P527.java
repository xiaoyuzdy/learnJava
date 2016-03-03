package Number_18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * P525�ĸĽ��� ʹ�������ڲ���
 * 
 * @author he
 * 
 */
public class P527 {
	// ��������Ϊfinal������������ʹ�����Ը��෶Χ֮��Ķ���
	public static void main(final String[] args) {
		File path = new File("F:/workspace/JavaThinking001/src/Number_fourteen");
		String[] list;

		list = path.list(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(args[0]);

			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		});

		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String string : list) {
			System.out.println(string);
		}

	}
}
