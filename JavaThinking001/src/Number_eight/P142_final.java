package Number_eight;
/**
 * �հ�final �ĸ�ֵ
 * @author he
 *
 */
public class P142_final {
	final private String i;
	final private String i2;
	final private Integer a;

	public P142_final(String ii, Integer x) {
		i2 = "�������и�ֵ";
		i = ii;
		a = x;
	}

	// ֻ����һ�������� ����������������ʾ��һ���հ�finalδ����
	/*
	 * public ewq(String ii){ i=ii; }
	 */

	// ��д toString���������� + ��integer ����ת��Ϊ string
	public String toString() {
		return "i2=" + i2 + "\ni=" + i + "\na=" + a;

	}

	public static void main(String[] args) {
		System.out.println(new P142_final("��������ʱ��ֵ", 2).toString());

	}

}
