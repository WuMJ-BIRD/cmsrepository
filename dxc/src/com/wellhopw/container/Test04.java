package com.wellhopw.container;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>Title: Test04.java</p>  
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: Wellhope</p>  
 * @author WuMJ 
 * @date 2020��3��5��  
 * @version 1.0  
 * LinkedBlockingDeque
 *
 */
public class Test04 {
	/**
	����add        ����һ��Ԫ��                     ����������������׳�һ��IIIegaISlabEepeplian�쳣
	����remove   �Ƴ������ض���ͷ����Ԫ��    �������Ϊ�գ����׳�һ��NoSuchElementException�쳣
	����element  ���ض���ͷ����Ԫ��             �������Ϊ�գ����׳�һ��NoSuchElementException�쳣
	����offer       ���һ��Ԫ�ز�����true       ��������������򷵻�false
	����poll         �Ƴ������ʶ���ͷ����Ԫ��    �������Ϊ�գ��򷵻�null
	����peek       ���ض���ͷ����Ԫ��             �������Ϊ�գ��򷵻�null
	����put         ���һ��Ԫ��                      �����������������
	����take        �Ƴ������ض���ͷ����Ԫ��     �������Ϊ�գ������� 
	
	   remove��element��offer ��poll��peek ��ʵ������Queue�ӿڡ�
	    
	 */
	final BlockingQueue<String> q = new LinkedBlockingDeque<String>();
	final Random r = new Random();
	public static void main(String[] args) {
		final Test04 t = new Test04();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						t.q.put("value:"+t.r.nextInt(1000));
						System.out.println("~~~~~~~~~~~~~~~~put~~~~~~~~~~~~~~~~~~~~~~");
						TimeUnit.SECONDS.sleep(1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}, "producer").start();
		
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							System.out.println(Thread.currentThread().getName()+" -- "+t.q.take());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}, "consumer"+i).start();
		}
		
	}
}
