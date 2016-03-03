package Number_1802;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 新I/O 通道，缓冲器 唯一直接与通道交互的缓冲器 ByteBuffer
 * FileInputStream,FileOutpuoStream,RandomAccessFile 有getChannel方法返回
 * FileChannel类型的对象
 * 
 * @author he
 * 
 */
public class P552 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// 创建通道fc
		FileChannel fc = new FileOutputStream("F:/IOtest/b/data.txt")
				.getChannel();
		// 将some txt 变为Byte数组 包装到缓冲区 ， 再写入通道fc
		fc.write(ByteBuffer.wrap("some txt ".getBytes()));
		fc.close();

		fc = new RandomAccessFile("F:/IOtest/b/data.txt", "rw").getChannel();
		// 设置位置移动到最后 方便再写入数据
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap("some more ".getBytes()));
		fc.close();

		fc = new FileInputStream("F:/IOtest/b/data.txt").getChannel();
		// 分配新的字节缓冲区
		ByteBuffer bb = ByteBuffer.allocate(1024);
		// 将通道中的数据写入缓冲区
		fc.read(bb);
		// 缓冲区反转
		bb.flip();

		while (bb.hasRemaining()) {
			System.out.print((char) bb.get());
		}

	}

}
