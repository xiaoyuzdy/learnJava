package Number_1802;

import java.io.*;

/**
 * 对象序列化和反序列化 必须实现Serializable 接口 关于反序列，因为对象已经是一个字节序列所以，不能用.read()方法判断 同时使用
 * string s =in.readObject()方法 虽然能够读取文件 但是会抛出EOFException 异常 可以利用这一点
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
		// 对象序列化
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				filename2));
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		while ((s = in.readLine()) != null) {
			// 通过writeObject() 实现序列化，打开文件很乱
			out.writeObject(s);
		}
		out.close();
		in.close();
		// 反序列化
		ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(
				filename2));

		System.out.println("因为是字节序列，所以用.read()方法永远是-1：" + in2.read());

		// 使用此方法虽然能读出文件但会抛出EOFException异常，因此利用这一点用第二种方法输出
		// String s2;
		// while((s2=(String)in2.readObject())!=null){
		// System.out.println(s2);
		// }

		while (true) {
			try {
				System.out.println(in2.readObject());
				// 当抛出EOFException时 则表明已经读到文件末尾
			} catch (EOFException e) {
				break;
			}
		}
		in2.close();
	}
}
