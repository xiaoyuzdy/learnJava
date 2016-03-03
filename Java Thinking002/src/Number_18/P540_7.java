package Number_18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * P540练习7
 * 
 * @author he
 * 
 */
public class P540_7 {
	public static String read(String filename) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader(filename));
		String s;
		List<String> list = new LinkedList<String>();
		List<String> list2 = new LinkedList<String>();
		while ((s = b.readLine()) != null) {
			list.add(s + "\n");
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			// 将字母全部变为大写
			list2.add(list.get(i).toUpperCase());
		}
		b.close();

		return list2.toString();

	}

	public static void main(String[] args) throws IOException {
		System.out
				.println(read("F:/workspace/Java Thinking002/src/Number_18/P540_7.java"));
	}
}
