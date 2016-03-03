package Number_18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * P540 ���������ļ�
 * 
 * @author he
 * 
 */
public class P540 {

	public static String read(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while ((s = in.readLine()) != null) {
			sb.append(s + "\n");
		}
		in.close();

		return sb.toString();

	}

	public static void main(String[] args) throws IOException {
		// ����Ϊȫ�޶���
		System.out
				.println(read("F:/workspace/Java Thinking002/src/Number_18/P540.java"));
	}

}
