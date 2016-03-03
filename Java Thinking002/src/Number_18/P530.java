package Number_18;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用工具栏类P528和PPrint
 * 
 * 测试文件夹为F:\workspace\3\src\file_io_liu
 * 
 * @author he
 * 
 */

public class P530 {

	public static void main(String[] args) {
		
		
		// 打印F:/workspace下的文件名,按书中这么写不行 必须按下面几种方式写
		//可能原因是在P528中重写了tostring 方法
//		 PPrint.pprint(P528.walk("F:/workspace/3/src").dirs);
		for (int i = 0; i < P528.walk("F:/workspace/3/src").dirs.size(); i++) {
			PPrint.pprint(P528.walk("F:/workspace/3/src").dirs.get(i));
		}
		// 或者这一种方式
		// System.out.println(P528.walk("F:/workspace/3/src").dirs);

		// 打印F:/workspace/3/src/file_io_liu 目录下D开头后缀是.java的文件
		for (File file : P528.local("F:/workspace/3/src/file_io_liu",
				"D.*\\.java")) {
			System.out.println(file);

		}
		System.out.println("--------------------------------");

	}
}
