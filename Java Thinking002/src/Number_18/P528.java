package Number_18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 目录实用工具
 * 
 * @author he
 * 
 */
public final class P528 {
	// 返回一个file对象数组
	public static File[] local(File dir, final String regex) {
		return dir.listFiles(new FilenameFilter() {

			private Pattern pattern = Pattern.compile(regex);

			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return pattern.matcher(new File(name).getName()).matches();
			}
		});

	}

	// 重载
	public static File[] local(String path, final String regex) {
		return local(new File(path), regex);
	}

	// 静态匿名内部类
	public static class TreeInfo implements Iterable<File> {

		public List<File> files = new ArrayList<File>();
		public List<File> dirs = new ArrayList<File>();

		public Iterator<File> iterator() {

			return files.iterator();
		}

		void addAll(TreeInfo other) {
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}

		@Override
		public String toString() {

			return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles"
					+ PPrint.pformat(files);
		}

	}

	public static TreeInfo recurseDirs(File dir, String regex) {

		TreeInfo result = new TreeInfo();
		for (File item : dir.listFiles()) {
			// 判断是否为文件夹
			if (item.isDirectory()) {
				result.dirs.add(item);
				// 递归遍历
				result.addAll(recurseDirs(item, regex));

			} else {
				// 如果是符合条件的文件
				if (item.getName().matches(regex)) {
					result.files.add(item);
				}
			}
		}
		return result;

	}

	// 获取list类型的文件名, 通过重载应对不同情况
	public static TreeInfo walk(String start, String regex) {
		return recurseDirs(new File(start), regex);
	}

	public static TreeInfo walk(File start) {
		return recurseDirs(start, ".*");
	}

	public static TreeInfo walk(String start) {
		return recurseDirs(new File(start), ".*");
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println(walk("."));
		} else {
			for (String argString : args) {
				System.out.println(walk(argString));
			}
		}
	}

}
