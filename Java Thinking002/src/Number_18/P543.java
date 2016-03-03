package Number_18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ���ݴ�����ָ�
 * 
 * @author he
 * 
 */
public class P543 {

	private static final String FILENAME = "F:/IOtest/b/b.txt";

	public static void main(String[] args) throws IOException {
		// д�� ����ļ��������Զ�����
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream(FILENAME)));
		out.writeDouble(1234.00);
		out.writeUTF("This is UTF");

		out.close();

		DataInputStream in = new DataInputStream(new BufferedInputStream(
				new FileInputStream(FILENAME)));

		System.out.println(in.readDouble());
		System.out.println(in.readUTF());

	}
}
