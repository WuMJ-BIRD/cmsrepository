package com.wellhopw.dxc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>Title: Test15.java</p>  
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: Wellhope</p>  
 * @author WuMJ 
 * @date 2020��2��24��  
 * @version 1.0  
 * 
 * ��˨���Ժ���ʹ�ã���������ġ�
 * ������δ����֮ǰ�ȴ�������֮����С�
 * ��������Ч�ʵ������⡣
 * 
 *
 */
public class Test15 {
	CountDownLatch latch = new CountDownLatch(5);
	
	void m1(){
		try {
			latch.await();//�ȴ����ſ���
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m1()~~~~~method");
	}
	
	void m2(){
		for (int i = 0; i < 10; i++) {
			if (latch.getCount() != 0) {
				System.out.println("latch count:"+latch.getCount());
				latch.countDown();//��˨�ϼ���
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("m2() method:"+i);
		}
	}
	
	public static void main(String[] args) {
		final Test15 t = new Test15();
		new Thread(new Runnable() {
			@Override
			public void run() {
				t.m1();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				t.m2();
			}
		}).start();
		
	}
	
}
