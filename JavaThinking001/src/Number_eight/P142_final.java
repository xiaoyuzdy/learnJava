package Number_eight;
/**
 * 空白final 的赋值
 * @author he
 *
 */
public class P142_final {
	final private String i;
	final private String i2;
	final private Integer a;

	public P142_final(String ii, Integer x) {
		i2 = "构造器中赋值";
		i = ii;
		a = x;
	}

	// 只能用一个构造器 用两个构造器会显示另一个空白final未定义
	/*
	 * public ewq(String ii){ i=ii; }
	 */

	// 重写 toString方法，运用 + 将integer 类型转换为 string
	public String toString() {
		return "i2=" + i2 + "\ni=" + i + "\na=" + a;

	}

	public static void main(String[] args) {
		System.out.println(new P142_final("创建对象时赋值", 2).toString());

	}

}
