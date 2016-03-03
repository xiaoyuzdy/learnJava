package Number_1802;

import java.io.*;

/**
 * �������л��ͷ����л� ����ʵ��Serializable �ӿ� ���ڷ����У���Ϊ�����Ѿ���һ���ֽ��������ԣ�������.read()�����ж� ͬʱʹ��
 * string s =in.readObject()���� ��Ȼ�ܹ���ȡ�ļ� ���ǻ��׳�EOFException �쳣 ����������һ��
 * 
 * 
 * @author he
 * 
 */
public class P573 implements Serializable {
	static String filename = "F:/workspace/Java Thinking002/src/Number_1802/P573.java";
	static String filename2 = "F:/IOtest/b/Serializable.txt";

	public static void main(String[] args) throws IOException, IOException,
			ClassNotFoundException {
		// �������л�
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				filename2));
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		while ((s = in.readLine()) != null) {
			// ͨ��writeObject() ʵ�����л������ļ�����
			out.writeObject(s);
		}
		out.close();
		in.close();
		// �����л�
		ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(
				filename2));

		System.out.println("��Ϊ���ֽ����У�������.read()������Զ��-1��" + in2.read());

		// ʹ�ô˷�����Ȼ�ܶ����ļ������׳�EOFException�쳣�����������һ���õڶ��ַ������
		// String s2;
		// while((s2=(String)in2.readObject())!=null){
		// System.out.println(s2);
		// }

		while (true) {
			try {
				System.out.println(in2.readObject());
				// ���׳�EOFExceptionʱ ������Ѿ������ļ�ĩβ
			} catch (EOFException e) {
				break;
			}
		}
		in2.close();
	}
}
