package N1;

/**
 * P88 标签类，标签类过于冗长，容易出错且效率低下
 * 
 * @author he
 *
 */
public class Figure {

	// 枚举类型，包含矩形和圆形
	enum Shape {
		RECTANGLE, CIRCLE
	};

	final Shape shape;

	// 用于矩形的变量
	double length;
	double weigth;

	// 用于圆形的变量
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
