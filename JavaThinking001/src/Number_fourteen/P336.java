package Number_fourteen;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * ���ߣ����÷�����ƻ�ȡ�����Ϣ���������������� �ֶ���������в���Ҫ�Ӱ���
 * 
 * @author he
 * 
 */

public class P336 {

	private static String usage = "usage:\n"
			+ "ShowMethods qualified.class.name\n";

	// ������ʽ ȥ����������ǰ������δ� �� Number_fourteen.P336.
	// java.lang.Object.
	// �Լ�native��final ����
	private static Pattern pattern = Pattern.compile("\\w+\\.|native|final");

	// ����Զ��幹�������������ع�������Ϣ
	// P336() {
	//
	// }

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println(usage);
			System.exit(1);

		}
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor[] constructors = c.getConstructors();

			if (args.length == 1) {
				for (Method method : methods) {
					// replaceAll�滻ģʽ�����ģʽ��ƥ������м����������κ�native��final���ɿո� ��
					System.out.println(pattern.matcher(method.toString())
							.replaceAll(" "));
				}
				for (Constructor constructor : constructors) {
					System.out.println(pattern.matcher(constructor.toString())
							.replaceAll(""));
				}
				lines = methods.length + constructors.length;
			}
			// ��������в��� args[1]����������ִ��
			else {
				for (Method method : methods) {
					if (method.toString().indexOf(args[1]) != -1) {
						System.out.println(pattern.matcher(method.toString())
								.replaceAll(" "));
						lines++;
					}
				}
				for (Constructor constructor : constructors) {
					if (constructor.toString().indexOf(args[1]) != -1) {
						// replaceAll�滻ģʽ�����ģʽ��ƥ������м����������κ�native��final���ɿո� ��
						System.out.println(pattern.matcher(
								constructor.toString()).replaceAll(""));
						lines++;
					}
				}

			}

		} catch (ClassNotFoundException e) {
			System.out.println("No find class " + e);

		}

	}
}
