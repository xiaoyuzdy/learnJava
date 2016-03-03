package Number_nine;

/**
 * 接口和工厂 创建两个接口 一个接口内返回另一个接口类型的方法（类似于组合）
 * 
 * 
 * 
 * @author he
 * 
 */

interface Cycle {
	int wheels();
}

interface CycleFactory {
	Cycle factory();
}

class Cycle1 implements Cycle {

	public int wheels() {

		return 2;
	}

}

class CycleFactory1 implements CycleFactory {

	public Cycle factory() {

		return new Cycle1();
	}

}

class Cycle2 implements Cycle {

	public int wheels() {

		return 4;
	}

}

class CycleFactory2 implements CycleFactory {

	public Cycle factory() {

		return new Cycle2();
	}

}

public class interface_and_factory {

	Cycle c1, c2;

	public static void main(String[] args) {
		interface_and_factory i = new interface_and_factory();
		CycleFactory cFactory1 = new CycleFactory1();
		i.c1 = cFactory1.factory();

		CycleFactory cFactory2 = new CycleFactory2();
		i.c2 = cFactory2.factory();
		System.out.println("1号工厂生产一辆车" + i.c1 + " 轮子 = " + i.c1.wheels());
		System.out.println("2号工厂生产一辆车" + i.c2 + "  轮子 =" + i.c2.wheels());

	}
}
