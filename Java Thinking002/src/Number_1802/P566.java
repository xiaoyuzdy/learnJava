package Number_1802;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * 对于文件加锁
 * 
 * @author he
 * 
 */
public class P566 {

	public static void main(String[] args) throws IOException,
			InterruptedException {
		FileOutputStream fo = new FileOutputStream("F:/IOtest/b/data2.txt",true);
		// 给文件加锁，返回该通道的独占锁定，如果另一个程序保持一个重叠锁定而无法获取锁定，则返回null
		FileLock fl = fo.getChannel().tryLock();

		if (fl != null) {
			System.out.println("file is locked");
			TimeUnit.MILLISECONDS.sleep(100);
			fl.release();
			System.out.println("file is unlocked");
		}

	}

}
