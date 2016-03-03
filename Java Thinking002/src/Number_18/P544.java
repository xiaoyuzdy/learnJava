package Number_18;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读写随机访问文件
 * 
 * @author he
 * 
 */
public class P544 {

	public static final String file = "F:/IOtest/b/a.txt";

	// 读取文件
	public static void display() throws IOException {
		// 以只读的方式打开文件
		RandomAccessFile rFile = new RandomAccessFile(file, "r");
		for (int i = 0; i < 7; i++) {
			System.out.println("i=" + i + " Value=" + rFile.readDouble());

		}
		System.out.println(rFile.readUTF());
		rFile.close();

	}

	public static void main(String[] args) throws IOException {
		// 写文件
		RandomAccessFile wFile = new RandomAccessFile(file, "rw");
		for (int i = 0; i < 7; i++) {
			wFile.writeDouble(i * 1.414);
		}
		wFile.writeUTF("UTF-8");
		wFile.close();
		display();
		wFile = new RandomAccessFile(file, "rw");
		// 因为double字节为8所以 用5*8的形式查找第五个双精度值 并修改
		wFile.seek(5 * 8);
		wFile.writeDouble(2.333);
		wFile.close();
		display();
	}

}
