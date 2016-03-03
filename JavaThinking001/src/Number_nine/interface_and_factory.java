package Number_nine;

/**
 * �ӿں͹��� ���������ӿ� һ���ӿ��ڷ�����һ���ӿ����͵ķ�������������ϣ�
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
		System.out.println("1�Ź�������һ����" + i.c1 + " ���� = " + i.c1.wheels());
		System.out.println("2�Ź�������һ����" + i.c2 + "  ���� =" + i.c2.wheels());

	}
}
