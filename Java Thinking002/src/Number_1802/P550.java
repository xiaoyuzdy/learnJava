package Number_1802;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
/**
 * I/O�ض��� 
 *  ������̨�����붨�򵽶�ȡһ���ļ�
 *  ���������̨���������һ���ļ�
 * 
 * @author he
 * 
 */
public class P550 {
	public static void main(String[] args) throws IOException {
		PrintStream console = System.out;
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(
				"F:/workspace/Java Thinking002/src/Number_1802/P550.java"));
		PrintStream out = new PrintStream(new BufferedOutputStream(
				new FileOutputStream("F:/IOtest/b/uotput.txt")));
		System.setIn(in);
		System.setOut(out);
		System.setErr(out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null && s.length() != 0) {
			System.out.println(s);
		}
		out.close();
		System.setOut(console);
	}
}
