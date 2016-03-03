package Number_19;

import java.util.EnumSet;

/**
 * 使用接口组织枚举，将元素分组
 * 
 * 随机生成菜单
 * 
 * @author he
 * 
 */

interface Food {
	enum Appetizer implements Food {
		SALAD, SOUP, SPRING_ROLLS;
	}

	enum MainCourse implements Food {
		LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, BINDALOO;
	}
}

enum Course {
	APPETIZER(Food.Appetizer.class), MAINCOURSE(Food.MainCourse.class);
	private Food[] values;

	private Course(Class<? extends Food> c) {
		values = c.getEnumConstants();
	}

	public Food random() {
		return Enums.random(values);
	}

}

public class P579 {
	public static void main(String[] args) {
		
		for (int i = 0; i < 4; i++) {
			for (Course course : Course.values()) {
				System.out.println(course.random());
			}
			System.out.println("---------");
		}

	}
}
