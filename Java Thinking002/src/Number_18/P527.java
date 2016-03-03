package Number_18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * P525的改进版 使用匿名内部类
 * 
 * @author he
 * 
 */
public class P527 {
	// 参数必须为final，这样他才能使用来自该类范围之外的对象
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
