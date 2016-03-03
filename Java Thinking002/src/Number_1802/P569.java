package Number_1802;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * 用Zip进行多文件保存
 * 
 * checksum 有两种类型 Adler32(速度快) , CRC32(速度慢些，但准确率高)
 * 
 * @author he
 * 
 */
public class P569 {

	public static void main(String[] args) throws IOException {
		// 创建一个zip文件
		ZipOutputStream zos = new ZipOutputStream(new CheckedOutputStream(
				new FileOutputStream("F:/IOtest/b/Ziptest.zip"), new Adler32()));
		BufferedOutputStream out = new BufferedOutputStream(zos);

		zos.setComment("A test of java ZIP");

		System.out.println("write file");

		BufferedReader in = new BufferedReader(new FileReader(
				"F:/workspace/Java Thinking002/src/Number_1802/P569.java"));
		// 往压缩文件中添加条目 即把P569.java添加到压缩文件中去
		zos.putNextEntry(new ZipEntry("P569.java"));

		int a;
		while ((a = in.read()) != -1) {
			out.write(a);
		}

		in.close();
		out.flush();
		out.close();

		// 读取解压缩文件
		ZipInputStream zis = new ZipInputStream(new CheckedInputStream(
				new FileInputStream("F:/IOtest/b/Ziptest.zip"), new Adler32()));

		BufferedReader in2 = new BufferedReader(new InputStreamReader(zis));
		ZipEntry z;
		while ((z = zis.getNextEntry()) != null) {
			System.out.println("File read: " + z);
			// 用下面几种方式打印均可
			// int c;
			// while ((c=in2.read())!=-1) {
			// System.out.print((char)c);
			// // System.out.write(c);
			// }
			String s;
			while ((s = in2.readLine()) != null) {
				System.out.println(s);
			}

		}

		ZipFile zFile = new ZipFile("F:/IOtest/b/Ziptest.zip");
		//返回枚举类型的条目
		Enumeration e = zFile.entries();
		while (e.hasMoreElements()) {
			ZipEntry entry = (ZipEntry) e.nextElement();
			System.out.println("压缩条目：" + entry);

		}

	}
}
