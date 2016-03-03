package Number_19;

/**
 * ������enum����
 * 
 * @author he
 * 
 */

enum Shrubbery {
	GROUND, CRAWLING, HANGING
}

public class P590 {
	public static void main(String[] args) {
		System.out.println(Shrubbery.values()[1]+"==");

		for (Shrubbery shr : Shrubbery.values()) {
			System.out.println(shr);
			System.out.println(shr.compareTo(Shrubbery.CRAWLING));
			System.out.println(shr == Shrubbery.GROUND);
			// �������ö�ٳ�����ص�ö������
			System.out.println(shr.getDeclaringClass());
			// ��ȡ����
			System.out.println(shr.name());
			// ��������
			System.out.println(shr.ordinal());
			System.out.println("-------------------");
		}
		for (String s : "GROUND,CRAWLING,HANGING".split(",")) {
			// ���ش���ָ���������͵�ö�ٳ���
			Shrubbery ss = Shrubbery.valueOf(Shrubbery.class, s);
			System.out.println(ss);
		}

	}
}
