package Number_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用executor (执行器) 管理thread对象 执行已提交的runnable任务的对象
 * 
 * @author he
 *
 */
public class P657 {

	public static void main(String[] args) {
		//创建线程池，线程数目不固定
		ExecutorService eService=Executors.newCachedThreadPool();
		//创建可重用的数目固定的线程池
		ExecutorService eService2=Executors.newFixedThreadPool(5);
		//创建单个线程，如果提交了多个任务，那么这些任务将排队
		 eService2=Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++){
			eService2.execute(new P654());		
		}
		//启用顺序关闭，不接受新任务,如果继续提交  将抛出java.util.concurrent.RejectedExecutionException异常
		eService.shutdown();
	}
	
	
}
