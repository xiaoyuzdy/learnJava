package Number_1802;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 用Gzip进行简单的压缩
 * 
 * @author he
 * 
 */

public class P568 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(
				"F:/IOtest/b/data3.txt"));

		// 创建压缩文件
		BufferedOutputStream out = new BufferedOutputStream(
				new GZIPOutputStream(new FileOutputStream(
						"F:/IOtest/b/data32.gz")));

		int a;
		while ((a = in.read()) != -1) {
			out.write(a);
		}

		in.close();
		out.close();
		// 文件解压缩
		BufferedReader in2 = new BufferedReader(new InputStreamReader(
				new GZIPInputStream(
						new FileInputStream("F:/IOtest/b/data32.gz"))));

		String s;
		while ((s = in2.readLine()) != null) {
			System.out.println(s);
		}

		in2.close();
	}

}
