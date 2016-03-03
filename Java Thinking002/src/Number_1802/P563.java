package Number_1802;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 内存映射文件
 * 
 * @author he
 * 
 */
public class P563 {
	private static final int length = 0x8FFFFFF; // 128M
//	static int length=0x7d;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, IOException {

		MappedByteBuffer out = new RandomAccessFile("F:/IOtest/b/data3.txt","rw")
				.getChannel().map(
				// 将此通道的文件区域映射到内存 ， 设置为只读，开始0 大小为length
						FileChannel.MapMode.READ_WRITE, 0, length);
		for (int i = 0; i < length; i++) {
			out.put((byte)'x');
		}
		System.out.println("Finished writing");
		for (int i = length / 2; i < length / 2 + 6; i++) {
			System.out.println((char)out.get(i));
		}

	}

}
