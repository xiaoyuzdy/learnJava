package Number_18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * 基本的文件输出
 * 
 * @author he
 * 
 */
public class P542 {
	private static final String filename = "F:/workspace/Java Thinking002/src/Number_18/P542.out";

	public static void main(String[] args) throws IOException {
		// 读入文件
		BufferedReader in = new BufferedReader(
				new StringReader(
						P540.read("F:/workspace/Java Thinking002/src/Number_18/P542.java")));
		// 写出文件
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				filename)));
		String s;
		int lineCount = 1;
		while ((s = in.readLine()) != null) {
			out.println(lineCount++ + ":" + s);
		}

		in.close();
		out.close();

		// 读出写入的文件
		System.out.println(P540.read(filename));

	}

}
