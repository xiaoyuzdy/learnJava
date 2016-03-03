package Number_1802;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * P546 文件读写工具
 * 
 * @author he
 * 
 */

public class TextFile extends ArrayList<String> {

	// 含有过滤功能的构造器
	TextFile(String filename, String filter) {

		super(Arrays.asList(filename.split(filter)));
		if (get(0) == "") {
			remove(0);
		}

	}

	// 重载构造器
	TextFile(String filename) {
		this(filename, "\n");
	}

	public static String read(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(
				new File(filename).getAbsoluteFile()));

		StringBuilder sb = new StringBuilder();
		String s;
		while ((s = in.readLine()) != null) {
			sb.append(s + "\n");
		}
		in.close();

		return sb.toString();

	}

	public static void write(String filename, String txt) throws IOException {

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				new File(filename).getAbsoluteFile())));
		// 在文件中写入txt
		out.print(txt);
		out.close();

	}

	// 重载write(),不能定义为static 否则不能使用this

	public void write(String filename) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				new File(filename).getAbsoluteFile())));
		// 这里的this指的是该文件的名字 即参数filename
		for (String item : this) {
			out.println(item);
		}

		out.close();
	}

	public static void main(String[] args) throws IOException {
		String file = read("F:/workspace/Java Thinking002/src/Number_18/TextFile.java");

		write("F:/IOtest/b/TextFile.txt", file);

		TextFile text = new TextFile(
				"F:/workspace/Java Thinking002/src/Number_18/TextFile.java");
		text.write("F:/IOtest/b/TextFile2.txt");

		TreeSet<String> words = new TreeSet<String>(new TextFile(
				"F:/workspace/Java Thinking002/src/Number_18/TextFile.java",
				"\\W+"));
		System.out.println(words.headSet("a"));

	}

}
