package Number_18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * �������ļ����
 * 
 * @author he
 * 
 */
public class P542 {
	private static final String filename = "F:/workspace/Java Thinking002/src/Number_18/P542.out";

	public static void main(String[] args) throws IOException {
		// �����ļ�
		BufferedReader in = new BufferedReader(
				new StringReader(
						P540.read("F:/workspace/Java Thinking002/src/Number_18/P542.java")));
		// д���ļ�
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				filename)));
		String s;
		int lineCount = 1;
		while ((s = in.readLine()) != null) {
			out.println(lineCount++ + ":" + s);
		}

		in.close();
		out.close();

		// ����д����ļ�
		System.out.println(P540.read(filename));

	}

}
