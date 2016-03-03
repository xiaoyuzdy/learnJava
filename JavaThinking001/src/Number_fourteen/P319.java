package Number_fourteen;

import java.util.Random;

/**
 * 1.�����泣�� .class �� forname()���������� 
 * 2.�����ڳ���
 * 
 * @author he
 * 
 */

class Initable {
	static final int staticFinal = 47;
	final static int staticFinal2 = 48;

	static final int staticFinal3 = P319.rand.nextInt(1000);

	static {
		System.out.println("��ʼ��1");
	}

}

class Initable2 {
	// static final �� final static ������ ���α����ڳ��� ��������ʼ��
	static int initable1 = 147;
	final int initable2 = 148;
	static {
		System.out.println("��ʼ��2");
	}

}

class Initable3 {

	static int initable31 = 44;
	static {
		System.out.println("��ʼ��3");
	}

}

public class P319 {
	public static Random rand = new Random(47);

	public static void main(String[] args) throws ClassNotFoundException {
		// ֻ����.class���ɶ�class��������� δ��ʼ��
		Class c = Initable.class;
		// ���������� ��������ʼ��
		System.out.println(Initable.staticFinal);
		System.out.println(Initable.staticFinal2);
		System.out.println("-------------------");
		// ��Ҫ�ȶ����ʼ������ܶ�ȡ
		System.out.println(Initable.staticFinal3);
		System.out.println("-------------------");
		System.out.println(Initable2.initable1);
		System.out.println("-------------------");
		// ʹ��forname()���� �������г�ʼ��
		Class c2 = Class.forName("Number_fourteen.Initable3");

		System.out.println("=================");

		System.out.println(Initable3.initable31);

	}
}
