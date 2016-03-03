package Number_1802;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 对映射文件的部分加锁
 * 
 * @author he
 * 
 */
public class P567 {

	static FileChannel fc;
	static final int length = 0x8FFFFFF;// 128M

	static class LockAndModify extends Thread {
		private ByteBuffer buffer;
		private int start;
		private int end;

		LockAndModify(ByteBuffer bb, int start, int end) {
			this.start = start;
			this.end = end;

			// 设置位置和边界
			bb.limit(end);
			bb.position(start);

			// 创建新的字节缓冲区
			buffer = bb.slice();
			// 虚拟机调用run()方法
			start();

		}

		@Override
		public void run() {

			try {
				// 不共享 独锁
				FileLock fl = fc.lock(start, end, false);
				// 验证加锁成功，在锁定区域加y
				while (buffer.position() < buffer.limit() - 1) {
					buffer.put((byte) (buffer.get() + 1));
				}
				fl.release();
				System.out.println("Released: " + start + "  to  " + end);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException();
			}
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// 创建内存映射
		fc = new RandomAccessFile("F:/IOtest/b/data4.txt", "rw").getChannel();
		MappedByteBuffer mBuffer = fc.map(FileChannel.MapMode.READ_WRITE, 0,
				length);

		for (int i = 0; i < length; i++) {
			mBuffer.put((byte) 'x');

		}

		new LockAndModify(mBuffer, 0, length / 3);
		new LockAndModify(mBuffer, length / 2, length / 2 + length / 4);
	}

}
