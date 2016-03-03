package Number_fourteen;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 工具：利用反射机制获取类的信息（方法，构造器） 手动添加命令行参数要加包名
 * 
 * @author he
 * 
 */

public class P336 {

	private static String usage = "usage:\n"
			+ "ShowMethods qualified.class.name\n";

	// 正则表达式 去掉方法名字前面的修饰词 即 Number_fourteen.P336.
	// java.lang.Object.
	// 以及native和final 修饰
	private static Pattern pattern = Pattern.compile("\\w+\\.|native|final");

	// 如果自定义构造器则结果不返回构造器信息
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
					// replaceAll替换模式与给定模式相匹配的序列即将命名修饰和native和final换成空格“ ”
					System.out.println(pattern.matcher(method.toString())
							.replaceAll(" "));
				}
				for (Constructor constructor : constructors) {
					System.out.println(pattern.matcher(constructor.toString())
							.replaceAll(""));
				}
				lines = methods.length + constructors.length;
			}
			// 检查命令行参数 args[1]如果有则继续执行
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
						// replaceAll替换模式与给定模式相匹配的序列即将命名修饰和native和final换成空格“ ”
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
