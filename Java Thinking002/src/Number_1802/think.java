package Number_1802;

/**
 *将一个序列化的对象添加到压缩文件
 *要将ZipOutputStream 添加到 ObjectOutputStream 中
 *不能是ObjectOutputStream添加到ZipOutputStream中，否则创建的文件写不了内容
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
