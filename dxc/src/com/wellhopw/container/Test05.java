package com.wellhopw.container;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>Title: Test05.java</p>  
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: Wellhope</p>  
 * @author WuMJ 
 * @date 2020��3��5��  
 * @version 1.0  
 * ArrayBlockingQueue:�ײ�����ʵ�ֵ��н���С��Զ����������ݵ���API��add/put/offer����ͬ���в�ͬ���ԡ�
 *
 */
public class Test05 {
	final BlockingQueue<String> q = new ArrayBlockingQueue<String>(3);
	final Random r = new Random();
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
	public static void main(String[] args) {
		Test05 t = new Test05();
		for (int i = 0; i < 5; i++) {
			//��add        ����һ��Ԫ��             ����������������׳�һ��IIIegaISlabEepeplian�쳣
//			System.out.println("add method : "+ t.q.add("value:"+i));
			
//			put         ���һ��Ԫ��                      �����������������
//			try {
//				t.q.put("value:"+i);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("put method : " + i);
			
//			offer       ���һ��Ԫ�ز�����true       ��������������򷵻�false
			//��һ�֣�������������
//			System.out.println("offer method : " + t.q.offer("value:"+i));
			//�ڶ��֣���������������ʱ������
			try {
				System.out.println("offer method : " + t.q.offer("value:"+i, 1 ,TimeUnit.SECONDS));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		System.out.println(t.q);
	}
}
