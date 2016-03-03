package Number_18;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��д��������ļ�
 * 
 * @author he
 * 
 */
public class P544 {

	public static final String file = "F:/IOtest/b/a.txt";

	// ��ȡ�ļ�
	public static void display() throws IOException {
		// ��ֻ���ķ�ʽ���ļ�
		RandomAccessFile rFile = new RandomAccessFile(file, "r");
		for (int i = 0; i < 7; i++) {
			System.out.println("i=" + i + " Value=" + rFile.readDouble());

		}
		System.out.println(rFile.readUTF());
		rFile.close();

	}

	public static void main(String[] args) throws IOException {
		// д�ļ�
		RandomAccessFile wFile = new RandomAccessFile(file, "rw");
		for (int i = 0; i < 7; i++) {
			wFile.writeDouble(i * 1.414);
		}
		wFile.writeUTF("UTF-8");
		wFile.close();
		display();
		wFile = new RandomAccessFile(file, "rw");
		// ��Ϊdouble�ֽ�Ϊ8���� ��5*8����ʽ���ҵ����˫����ֵ ���޸�
		wFile.seek(5 * 8);
		wFile.writeDouble(2.333);
		wFile.close();
		display();
	}

}
