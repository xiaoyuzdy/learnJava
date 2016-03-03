package Number_1802;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * �����ļ�����
 * 
 * @author he
 * 
 */
public class P566 {

	public static void main(String[] args) throws IOException,
			InterruptedException {
		FileOutputStream fo = new FileOutputStream("F:/IOtest/b/data2.txt",true);
		// ���ļ����������ظ�ͨ���Ķ�ռ�����������һ�����򱣳�һ���ص��������޷���ȡ�������򷵻�null
		FileLock fl = fo.getChannel().tryLock();

		if (fl != null) {
			System.out.println("file is locked");
			TimeUnit.MILLISECONDS.sleep(100);
			fl.release();
			System.out.println("file is unlocked");
		}

	}

}
