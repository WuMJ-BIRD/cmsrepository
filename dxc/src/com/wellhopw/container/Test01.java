package com.wellhopw.container;

import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>Title: Test01.java</p>  
 * <p>Description: ThreadLocal</p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: Wellhope</p>  
 * @author WuMJ 
 * @date 2020��3��4��  
 * @version 1.0  
 * ����һ��map��key --��Thread.getCurrentThread(). value --�� ������Ҫ�����׃��
 * ThreadLocal.set(value)  ->  map.put(Thread.getCurrentThread(), value)
 * ThreadLocal.get()	   ->  map.get(Thread.getCurrentThread());
 * �ڴ����⣺�������ߵ�ʱ����ܳ�����������⡣
 * ʹ��ThreadLocal��ʱ��һ��Ҫע����Դ���Ѻ����⣬ÿ���߳̽���֮ǰ������ǰ���̵߳��̱߳���һ��Ҫɾ��
 * ThreadLocal.remove();���򻢴̻����ڴ�й©���⡣
 * ThreadLocal��remove���⣺
 *
 */
public class Test01 {
	volatile static String name = "zhangsan";
	static ThreadLocal<String> tl = new ThreadLocal<String>();
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(name);
				System.out.println(tl.get());
				tl.remove();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				name = "lisi";
				tl.set("sdfsdfdsfdsdfdsfdsfsdfsdf");
				tl.remove();
			}
		}).start();
	}
	
}
