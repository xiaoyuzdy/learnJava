package Number_19;

/**
 * 基本的enum特性
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
			// 返回与此枚举常量相关的枚举类型
			System.out.println(shr.getDeclaringClass());
			// 获取名字
			System.out.println(shr.name());
			// 返回序数
			System.out.println(shr.ordinal());
			System.out.println("-------------------");
		}
		for (String s : "GROUND,CRAWLING,HANGING".split(",")) {
			// 返回带有指定参数类型的枚举常量
			Shrubbery ss = Shrubbery.valueOf(Shrubbery.class, s);
			System.out.println(ss);
		}

	}
}
