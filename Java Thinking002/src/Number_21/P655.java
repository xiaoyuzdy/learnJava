package Number_21;

/**
 * thread 类
 * 
 * @author he
 *
 */
public class P655 {
	public static void main(String[] args) {
		// 创建thread实例 构造器中传实现了runnable的类， .start() 执行该线程
		for (int i = 0; i < 5; i++) {
			new Thread(new P654()).start();

		}
		System.out.println("waiting for p654()");
	}
}
