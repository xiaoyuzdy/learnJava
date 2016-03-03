package Number_21;

import java.util.concurrent.TimeUnit;

/*
 * 后台线程        
 * 只要有一个非后台线程在运行则程序就不会终止
 * @author he
 *
 */
public class P662 implements Runnable{

	public void run() {
		while(true){
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				//输出线程的引用
				System.out.println(Thread.currentThread());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<5;i++){
			Thread demo=new Thread(new P662());
			//设置为后台线程
			demo.setDaemon(true);
			demo.start();
		}
		System.out.println("All demo starts");
		TimeUnit.MILLISECONDS.sleep(200);
	}
	
	

}
