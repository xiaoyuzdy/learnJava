package Number_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ʹ��executor (ִ����) ����thread���� ִ�����ύ��runnable����Ķ���
 * 
 * @author he
 *
 */
public class P657 {

	public static void main(String[] args) {
		//�����̳߳أ��߳���Ŀ���̶�
		ExecutorService eService=Executors.newCachedThreadPool();
		//���������õ���Ŀ�̶����̳߳�
		ExecutorService eService2=Executors.newFixedThreadPool(5);
		//���������̣߳�����ύ�˶��������ô��Щ�����Ŷ�
		 eService2=Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++){
			eService2.execute(new P654());		
		}
		//����˳��رգ�������������,��������ύ  ���׳�java.util.concurrent.RejectedExecutionException�쳣
		eService.shutdown();
	}
	
	
}
