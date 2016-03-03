package Number_18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 目录列表器（过滤文件夹） 过滤F:/workspace/JavaThinking001/src/Number_fourteen目录下的
 * P开头后缀为.java的文件
 * 
 * args 为P.*\.java
 * 
 * @author he
 * 
 */

class DirFilter implements FilenameFilter {
	private Pattern pattern;

	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}

	// File必须指定到带含有该过滤文件的文件夹
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}

}

public class P525 {

	public static void main(String[] args) {
		File path = new File("F:/workspace/JavaThinking001/src/Number_fourteen");
		String[] list;
		if (args.length == 0) {
			list = path.list();
		} else {
			list = path.list(new DirFilter(args[0]));
		}
		// 排序忽略字母大小写
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String string : list) {
			System.out.println(string);
		}
	}
}
