package Number_2102;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �߳��쳣����
 * 
 * �����̵߳ı������ԣ�ʹ���㲻�ܲ�����߳������ݵ��쳣 δ�����쳣��
 * 
 * @author he
 *
 */

class EXcept implements Runnable {
	public void run() {
		// TODO Auto-generated method stub
		throw new RuntimeException();
	}

}

public class P672 {

	public static void main(String[] args) {
		ExecutorService eService = Executors.newCachedThreadPool();
		eService.execute(new EXcept());
	}

}
