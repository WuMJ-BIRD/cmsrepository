package com.wellhopw.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * 
 * <p>Title: Test02.java</p>  
 * <p>Description: �̳߳�</p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: Wellhope</p>  
 * @author WuMJ 
 * @date 2020��3��6��  
 * @version 1.0  
 * FixedThreadPool - �̶��������̳߳أ�����ʱ��Ҫָ��������
 * ExecutorService - �̳߳ط������͡��̳���Executor�ӿڣ����е��̳߳ض�ʵ��������ӿڡ�
 * 					  ʵ������ӿڣ���������ṩ�̳߳�������
 * Executors - Executor�Ĺ����ࡣ����Collection��Collections�Ĺ�ϵ��
 * 			       ���Ը��򵥵Ĵ����������̳߳ء�
 * shutdown:���Źرա�����ǿ�йر��̳߳أ������̳߳��е���Դ��
 * 			���ǲ��ڽ����µ����񣬽��Ѿ����յ�����������Ժ��ٴιرա�
 *
 */
public class Test02 {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 5; i++) {
			service.execute(new Runnable() {
				public void run() {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " test executor ");
				}
			});
		}
		System.out.println(service);
		service.shutdown();//֮�������ٴ���
		//�Ƿ��Ѿ��������൱�ڻ�������Դ��
		System.out.println(service.isTerminated());
		//�Ƿ��Ѿ��رգ��Ƿ���ù�shutDown����
		System.out.println(service.isShutdown());
		System.out.println(service);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�Ƿ��Ѿ��������൱�ڻ�������Դ��
		System.out.println(service.isTerminated());
		//�Ƿ��Ѿ��رգ��Ƿ���ù�shutDown����
		System.out.println(service.isShutdown());
		System.out.println(service);
		
	}
}
