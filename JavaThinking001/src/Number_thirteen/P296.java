package Number_thirteen;

/**
 * ����������ʽ
 * 
 * @author he
 * 
 */

public class P296 {
	public static void main(String[] args) {
		System.out.println("123456".matches("-?\\d+"));// matches
														// �����ַ����Ƿ�ƥ�������������ʽ
		System.out.println("+23456".matches("-?\\d+"));
		System.out.println("+23456".matches("(-|\\+)?\\d+"));
	}
}
