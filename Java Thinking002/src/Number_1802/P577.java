package Number_1802;

import java.io.*;

/**
 * Externalizable ʵ���� Serializable �ӿ� �����writeEXternal��readExternal����
 * ʹ��readExternal ����ʹ�ù��е��޲ι���������һ��ʵ���ٵ���readExternal���� ���Ա���Ҫ�й��е��޲ι�����
 * 
 * ��Ҫ���л��Ķ�����writeExternal��ʵ�� �����л��Ķ����� readExternal��ʵ��
 * 
 * @author he
 * 
 */
public class P577 implements Externalizable {
	static String filename = "F:/IOtest/b/Externalizable.txt";

	String s;
	int i;

	public P577() {
		System.out.println("default Constructor");
	}

	public P577(String s1, int i1) {
		System.out.println("P577(string,int)");
		s = s1;
		i = i1;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "S= " + s + " i= " + i;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("writeExternal ");
		out.writeObject(s);
		out.writeInt(i);

	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("readExternal ");
		s = (String) in.readObject();
		i = in.readInt();

	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		P577 p = new P577("AA", 11);
		System.out.println("---------");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				filename));
		out.writeObject(p);
		out.close();
		System.out.println("--------");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				filename));
		P577 s2 = (P577) in.readObject();
		System.out.println(s2);

	}
}
