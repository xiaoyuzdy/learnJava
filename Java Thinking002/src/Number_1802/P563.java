package Number_1802;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * �ڴ�ӳ���ļ�
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
				// ����ͨ�����ļ�����ӳ�䵽�ڴ� �� ����Ϊֻ������ʼ0 ��СΪlength
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
