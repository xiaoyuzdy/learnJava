package Number_1802;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ��I/O ͨ���������� Ψһֱ����ͨ�������Ļ����� ByteBuffer
 * FileInputStream,FileOutpuoStream,RandomAccessFile ��getChannel��������
 * FileChannel���͵Ķ���
 * 
 * @author he
 * 
 */
public class P552 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// ����ͨ��fc
		FileChannel fc = new FileOutputStream("F:/IOtest/b/data.txt")
				.getChannel();
		// ��some txt ��ΪByte���� ��װ�������� �� ��д��ͨ��fc
		fc.write(ByteBuffer.wrap("some txt ".getBytes()));
		fc.close();

		fc = new RandomAccessFile("F:/IOtest/b/data.txt", "rw").getChannel();
		// ����λ���ƶ������ ������д������
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap("some more ".getBytes()));
		fc.close();

		fc = new FileInputStream("F:/IOtest/b/data.txt").getChannel();
		// �����µ��ֽڻ�����
		ByteBuffer bb = ByteBuffer.allocate(1024);
		// ��ͨ���е�����д�뻺����
		fc.read(bb);
		// ��������ת
		bb.flip();

		while (bb.hasRemaining()) {
			System.out.print((char) bb.get());
		}

	}

}
