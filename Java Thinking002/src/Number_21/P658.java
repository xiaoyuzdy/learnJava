package Number_21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ����һ���з���ֵ���߳� ʵ��callable�ӿ� ��дcall���� callable ���з���ֵ�ֿ���ʹ�÷���
 * 
 * @author he
 *
 */

class Task implements Callable<String> {
	int id;

	public Task(int i) {
		id = i;
	}

	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "Task id=" + id;
	}

}

public class P658 {

	public static void main(String[] args) {
		List<Future<String>> list=new ArrayList<Future<String>>();
		//�����̳߳�
		ExecutorService eService=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			list.add(eService.submit(new Task(i)));
		}
		
		for (Future<String> future : list) {
			 try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 finally {
				eService.shutdown();
			}
		}
		
		
	}
	
	
}
