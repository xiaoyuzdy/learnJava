package Number_ten;
/**
 * 在嵌套内部类中测试外部类
 * @author he
 *
 */

public class P203 {

	public void f(){
		System.out.println("测试外部类");
	}
	
	static class Test{
		public static void main(String[] args) {
			P203 p=new P203();
			p.f();
		}
	}
	
	
}
