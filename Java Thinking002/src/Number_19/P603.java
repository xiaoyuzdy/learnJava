package Number_19;

import java.text.DateFormat;
import java.util.Date;

/**
 * enum的常量相关方法 enum实例允许编写方法， 但是要为enum写一个或多个抽象方法然后enum实例实现该抽象方法
 * 
 * @author he
 * 
 */

public enum P603 {
	DATE_TIME {

		@Override
		String getInfo() {
			return DateFormat.getInstance().format(new Date());
		}

	},
	CLASSPATH {

		@Override
		String getInfo() {
			// TODO Auto-generated method stub
			//获取Java版本信息
			return System.getProperty("java.version");
		}

	};

	abstract String getInfo();

	public static void main(String[] args) {

		for (P603 p : values()) {
			System.out.println(p.getInfo());
		}
	}
}
