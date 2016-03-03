package Number_1802;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * ��Zip���ж��ļ�����
 * 
 * checksum ���������� Adler32(�ٶȿ�) , CRC32(�ٶ���Щ����׼ȷ�ʸ�)
 * 
 * @author he
 * 
 */
public class P569 {

	public static void main(String[] args) throws IOException {
		// ����һ��zip�ļ�
		ZipOutputStream zos = new ZipOutputStream(new CheckedOutputStream(
				new FileOutputStream("F:/IOtest/b/Ziptest.zip"), new Adler32()));
		BufferedOutputStream out = new BufferedOutputStream(zos);

		zos.setComment("A test of java ZIP");

		System.out.println("write file");

		BufferedReader in = new BufferedReader(new FileReader(
				"F:/workspace/Java Thinking002/src/Number_1802/P569.java"));
		// ��ѹ���ļ��������Ŀ ����P569.java��ӵ�ѹ���ļ���ȥ
		zos.putNextEntry(new ZipEntry("P569.java"));

		int a;
		while ((a = in.read()) != -1) {
			out.write(a);
		}

		in.close();
		out.flush();
		out.close();

		// ��ȡ��ѹ���ļ�
		ZipInputStream zis = new ZipInputStream(new CheckedInputStream(
				new FileInputStream("F:/IOtest/b/Ziptest.zip"), new Adler32()));

		BufferedReader in2 = new BufferedReader(new InputStreamReader(zis));
		ZipEntry z;
		while ((z = zis.getNextEntry()) != null) {
			System.out.println("File read: " + z);
			// �����漸�ַ�ʽ��ӡ����
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
		//����ö�����͵���Ŀ
		Enumeration e = zFile.entries();
		while (e.hasMoreElements()) {
			ZipEntry entry = (ZipEntry) e.nextElement();
			System.out.println("ѹ����Ŀ��" + entry);

		}

	}
}
