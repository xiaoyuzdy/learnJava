package Number_twelve;

/**
 * 自定义异常
 * 
 * @author he
 * 
 */

class SimpleException extends Exception {
	SimpleException() {
	}

	SimpleException(String mes) {
		super(mes);
	}

	public void f() throws SimpleException {

		System.out.println("easy");

		throw new SimpleException("hahaha");

	}

}

public class P251_yichang {

	// public void f() throws SimpleException {
	//
	// System.out.println("easy");
	//
	// throw new SimpleException("hahaha");
	//
	// }

	public static void main(String[] args) {
		// P251_yichang a = new P251_yichang();
		SimpleException a = new SimpleException();

		try {
			a.f();
		} catch (SimpleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.err);
			System.out.println("放屁 !!!" + e.getMessage());
			// 重新抛出异常
			try {
				// 直接抛出异常栈轨迹信息未刷新
				/** 结果:
				 * easy Number_twelve.SimpleException: hahaha at
				 * Number_twelve.SimpleException.f(P251_yichang.java:21) at
				 * Number_twelve.P251_yichang.main(P251_yichang.java:42) 放屁
				 * !!!hahaha Number_twelve.SimpleException: hahaha at
				 * Number_twelve.SimpleException.f(P251_yichang.java:21) at
				 * Number_twelve.P251_yichang.main(P251_yichang.java:42)
				 */
				
				
//				 throw e;

				
				// 返回内部记录栈帧的当前状态刷新栈轨迹信息
				/**  结果:
				 * easy Number_twelve.SimpleException: hahaha at
				 * Number_twelve.SimpleException.f(P251_yichang.java:22) at
				 * Number_twelve.P251_yichang.main(P251_yichang.java:43) 放屁
				 * !!!hahaha Number_twelve.SimpleException: hahaha at
				 * Number_twelve.P251_yichang.main(P251_yichang.java:65)
				 */
				throw (Exception) e.fillInStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
		}

	}

}
