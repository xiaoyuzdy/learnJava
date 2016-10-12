package N1;

/**
 * P88 ��ǩ�࣬��ǩ������߳������׳�����Ч�ʵ���
 * 
 * @author he
 *
 */
public class Figure {

	// ö�����ͣ��������κ�Բ��
	enum Shape {
		RECTANGLE, CIRCLE
	};

	final Shape shape;

	// ���ھ��εı���
	double length;
	double weigth;

	// ����Բ�εı���
	double radius;

	public Figure(double radius) {
		shape = Shape.CIRCLE;
		this.radius = radius;
	}

	public Figure(double length, double weigth) {
		shape = Shape.RECTANGLE;
		this.length = length;
		this.weigth = weigth;
	}

	double area() {
		switch (shape) {
		case CIRCLE:
			return Math.PI * (radius * radius);
		case RECTANGLE:
			return length * weigth;
		default:
			throw new AssertionError();
		}
	}

}
