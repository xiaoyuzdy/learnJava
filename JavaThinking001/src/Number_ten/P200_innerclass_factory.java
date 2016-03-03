package Number_ten;

/**
 * ��ھ��µ�interface��factory �Ƚ� innerclass_factory��ȣ�
 * factory�ӿ�����ʵ�� ͨ�������ڲ���ķ�ʽʵ��
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
