package Number_1802;

/**
 *��һ�����л��Ķ�����ӵ�ѹ���ļ�
 *Ҫ��ZipOutputStream ��ӵ� ObjectOutputStream ��
 *������ObjectOutputStream��ӵ�ZipOutputStream�У����򴴽����ļ�д��������
 *
 *
 */
import java.io.*;
import java.util.zip.*;

class Ser implements Serializable {
	String s;

	public Ser(String ss) {
		s = ss;
	}
}

public class think {
	public static void main(String[] args) throws IOException {
		// ObjectOutputStream out1=new ObjectOutputStream(new
		// FileOutputStream("F:/IOtest/b/test222.txt"));

		CheckedOutputStream c = new CheckedOutputStream(new FileOutputStream(
				"F:/IOtest/b/SerZip.zip"), new Adler32());
		ZipOutputStream zout = new ZipOutputStream(c);
		// BufferedOutputStream out=new BufferedOutputStream(zout);
		zout.putNextEntry(new ZipEntry("ser2.txt"));

		ObjectOutputStream out1 = new ObjectOutputStream(zout);

		out1.writeObject(new Ser("aaaa"));

		// out.flush();
		// out.close();
		zout.close();
		out1.close();

	}
	//
}
