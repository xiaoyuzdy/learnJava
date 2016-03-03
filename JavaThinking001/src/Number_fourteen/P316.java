package Number_fourteen;

/**
 * Class�ļ�Ӧ��
 * 
 * @author he
 * 
 */

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
	public Toy() {
	}

	Toy(int i) {
	}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {

	FancyToy() {
		super(1);
	}
}

public class P316 {
	static void printInfo(Class cc) {
		System.out.println("Class name " + cc.getName() + "  isInterface? "
				+ cc.isInterface());
		System.out.println("  Simplename  " + cc.getSimpleName()
				+ "  CanonicalName " + cc.getCanonicalName());
	}

	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("Number_fourteen.FancyToy");
		} catch (ClassNotFoundException e) {
			System.out.println("No find ");
			System.exit(1);
		}

		printInfo(c);

		for (Class face : c.getInterfaces()) {
			printInfo(face);
		}

		Class up = c.getSuperclass();
		Object o = null;
		try {
			//ʹ��newInstance��������������Ĭ�Ϲ�����
			o = up.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		printInfo(o.getClass());

	}
}
