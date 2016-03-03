package Number_ten;

/**
 * 与第九章的interface和factory 比较 innerclass_factory相比，
 * factory接口无需实现 通过匿名内部类的方式实现
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

	public static CycleFactory cycleFactory = new CycleFactory() {

		public Cycle factory() {

			return new Cycle1();
		}
	};

}

class Cycle2 implements Cycle {

	public int wheels() {

		return 4;
	}

	public static CycleFactory cycleFactory2 = new CycleFactory() {

		public Cycle factory() {

			return new Cycle2();
		}
	};

}

public class P200_innerclass_factory {
public static void cycleConsumer(CycleFactory cf){
	Cycle c1=cf.factory();
	System.out.println(c1.wheels());
	
	
}
	public static void main(String[] args) {
		cycleConsumer(Cycle1.cycleFactory);
		cycleConsumer(Cycle2.cycleFactory2);

	}
}
