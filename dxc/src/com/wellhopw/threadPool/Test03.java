package com.wellhopw.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>Title: Test03.java</p>  
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: Wellhope</p>  
 * @author WuMJ 
 * @date 2020��3��6��  
 * @version 1.0  
 *
 */
public class Test03 {
	/**
	1.Executor
		�̳߳صĶ����ӿڡ����巽��void excute(Runnable)�����������ڴ��������һ�����񷽷���
		�������ṩRunnable�ӿ�ʵ�֣��̳߳�ͨ���߳�ִ��Runnable�����񷽷��޷���ֵ��ӦΪrun����
		�޷���ֵ��
		���ã������̡߳�
	2.ExecutorService
		Executor���ӽӿڡ�
		�ṩ��һ�����еķ��񷽷����з���ֵ��submit
		���ط����У�Runnable �������ṩ����ֵ��Callable �ṩ�˷���ֵ
		����������void excute(Runnable), Future submit(Callable), Future submit(Runnable)
		�̳߳�״̬��Running, ShuttingDown, Terminated
		Running:�̳߳ػ�Ծ״̬��
		ShuttingDown���̳߳����ڹرչ����С����Źرգ�һ���������״̬���̳߳ز��ٽ����µ����񣬴��������Ѿ����յ�����
					   ������Ϻ󣬹ر��̳߳ء�
		Terminated���߳��Ѿ��رգ�����״̬��
		
		java.util.concurrent.ThreadPoolExecutor@5c647e05
			[Running, pool size = 3, active threads = 3, queued tasks = 2, completed tasks = 0]
		false
		true
		java.util.concurrent.ThreadPoolExecutor@5c647e05
			[Shutting down, pool size = 3, active threads = 3, queued tasks = 2, completed tasks = 0]
		pool-1-thread-2 test executor 
		pool-1-thread-3 test executor 
		pool-1-thread-1 test executor 
		pool-1-thread-3 test executor 
		pool-1-thread-2 test executor 
		true
		true
		java.util.concurrent.ThreadPoolExecutor@5c647e05
			[Terminated, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 5]
	3.Future 
		δ������������߳�ִ�н�����Ľ����
		���÷�����T.get(),�����ȴ�;
			   T.get(long, TimeUnit),�����ȴ�,��ʱ�׳��쳣;
	4.Callable 
		��ִ�нӿڡ�������Runnable�ӿڣ�Ҳ������һ���̵߳ķ������ṩ��һ��call��������ͬ��run������
		����ֵΪObject
	5.Executors
		������
	*/
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(1);
		Future<String> submit = service.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				TimeUnit.SECONDS.sleep(1);
				System.out.println("aaaaaa");
				return Thread.currentThread().getName()+" test future ";
			}
		});
		System.out.println(submit);
		System.out.println(submit.isDone());//isDone(),�鿴�߳��Ƿ�ִ����ɣ���call����ִ����ϡ�
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
		try {
			System.out.println(submit.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(submit.isDone());
		
	}
	
	
	
}
