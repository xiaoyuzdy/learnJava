package Number_ten;

/**
 * 匿名内部类中使用的参数必须为final 对于匿名类而言，实例初始化相当于构造器
 * 
 * @author he
 * 
 */

public class P199 {

	public A aa(final float dest, final String price) {
		return new A() {
			private String label = price;

			 {

				System.out.println(label); 
			}

			private float number;

			{
				number = Math.round(dest);
				if (number > 100) {
					System.out.println("ok");

				}

			}

		};

	};

	public static void main(String[] args) {
		P199 p = new P199();
		A a = p.aa(121.339F, "success");
		
	}

}
