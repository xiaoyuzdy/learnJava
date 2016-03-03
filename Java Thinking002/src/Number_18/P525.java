package Number_18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Ŀ¼�б����������ļ��У� ����F:/workspace/JavaThinking001/src/Number_fourteenĿ¼�µ�
 * P��ͷ��׺Ϊ.java���ļ�
 * 
 * args ΪP.*\.java
 * 
 * @author he
 * 
 */

class DirFilter implements FilenameFilter {
	private Pattern pattern;

	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}

	// File����ָ���������иù����ļ����ļ���
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
		// ���������ĸ��Сд
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String string : list) {
			System.out.println(string);
		}
	}
}
