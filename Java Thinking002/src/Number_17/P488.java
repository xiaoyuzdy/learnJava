package Number_17;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 散列和散列码
 * 
 * @author he
 * 
 */

class Groundhog {
	private int number;

	public Groundhog(int i) {
		number = i;
	}

	@Override
	public String toString() {
		return "Number#:" + number;
	}

}

class Predction {
	private static Random rand = new Random(47);
	private boolean show = rand.nextDouble() > 0.5;

	@Override
	public String toString() {
		if (show) {
			return "Six more weeks of Winter";
		}
		return "Early Spring";
	}

}

public class P488 {

	public static <T extends Groundhog> void detectSpring(Class<T> type)
			throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		Map<Groundhog, Predction> map = new HashMap<Groundhog, Predction>();

		// int.class 为构造器的参数类型
		Constructor<T> gro = type.getConstructor(int.class);

		for (int i = 0; i < 5; i++) {
			// map中添加Groundhog和predction的实例
			map.put(gro.newInstance(i), new Predction());
		}
		System.out.println("Map " + map);

		Groundhog g = gro.newInstance(3);
		System.out.println("New " + g);
		if (map.containsKey(g)) {
			System.out.println("yes");
		} else {
			System.out.println("No found");
		}

	}

	public static void main(String[] args) throws NoSuchMethodException,
			SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		detectSpring(Groundhog.class);
	}

}
