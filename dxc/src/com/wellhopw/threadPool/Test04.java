package com.wellhopw.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test04 {
	/**
	5.Executors 
		�����ࡣΪExecutor�ṩ�������ܹ����ٵ��ṩ�������̡߳���
	�̶������ģ����������ģ�����Ϊ1���̳߳ء�
		�̳߳��ǽ��̼������������Դ��Ĭ�ϵ��������ں�JVMһ�£��������̳߳ص�
	ʱ��֪��JVM�ر�Ϊֹ�����̳߳ص�Ĭ���������ڡ��ֶ�����shutdown����������
	�߳�ִ����Ϻ��Զ��رա�
	6.FixedThreadPool
		�̶��������̳߳أ����������ޡ����е��̳߳��У�����һ��������У�����ʹ��
	BlockingQueue<Runnable>Ϊ����ʵ�ֵġ����������������̳߳ص�������ʱ��
	û�����е����񱣴�����������У����߳��п��е�ʱ���Զ��Ӷ�����ȡ������ִ�С�
	queued tasks �������
	completed tasks �����������
	
	ʹ�ó�����
		���������£�ʹ���̳߳أ���ѡ�Ƽ�FixedThreadPool����Ϊos����ϵͳ��
	Ӳ��֧���������޵ġ��������������Ƶ��ṩ�̳߳ء�
		�̳߳�����ΪInteger.MAX_VALUE
	
	7.CachedThreadPool
		�����������̳߳ء��̳߳�����ΪInteger.MAX_VALUE 2^31���Զ����ݡ�
		�̹߳�����ԣ��̳߳��е��߳�����޷�����������Ļ��ͻᴴ���̣߳����߳�
	����ʱ��ﵽ����(�߳�Ĭ�Ͽ���60��)���Զ��ͷŻ��ա�
		Ӧ�ó������ڲ�Ӧ�úͲ����á��������ܣ����������ڲ�Ӧ���ǣ������ܹ��ܿ������
		
		
	*/	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		System.out.println(service);
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
		try {
			TimeUnit.SECONDS.sleep(65);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(service);
	}
	
}
