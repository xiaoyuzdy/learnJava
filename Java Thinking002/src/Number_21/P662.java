package Number_21;

import java.util.concurrent.TimeUnit;

/*
 * ��̨�߳�        
 * ֻҪ��һ���Ǻ�̨�߳������������Ͳ�����ֹ
 * @author he
 *
 */
public class P662 implements Runnable{

	public void run() {
		while(true){
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				//����̵߳�����
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
			//����Ϊ��̨�߳�
			demo.setDaemon(true);
			demo.start();
		}
		System.out.println("All demo starts");
		TimeUnit.MILLISECONDS.sleep(200);
	}
	
	

}
