package Number_1802;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ×ª»»Êý¾Ý
 * 
 * @author he
 * 
 */
public class P554 {
	static final String filename = "F:/IOtest/b/data2.txt";

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		FileChannel fc = new FileOutputStream(filename).getChannel();
		fc.write(ByteBuffer.wrap("abc def".getBytes("UTF-16BE")));
		fc.close();

		fc = new FileInputStream(filename).getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		fc.read(buffer);
		buffer.flip();
		System.out.println(buffer.asCharBuffer());

		fc = new FileOutputStream(filename).getChannel();
		buffer=ByteBuffer.allocate(20);
		buffer.asCharBuffer().put("some");
		fc.write(buffer);
		fc.close();

		fc = new FileInputStream(filename).getChannel();
		buffer.clear();
		fc.read(buffer);
		buffer.flip();
		System.out.println(buffer.asCharBuffer());

	}

}
