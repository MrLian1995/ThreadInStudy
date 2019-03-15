package com.lyl.thread.base;
/**
 * 军队线程
 * 模拟作战双方的行为
 * @author Administrator
 *
 */
public class ArmyRunnable implements Runnable{

	//volatile保证了线程可以正确读取其他线程写入的值
	//可见性 ref JMM(java内存模型)  happens-before原则
	volatile boolean keepRunning=true;

	public void run() {
		while(keepRunning){
			for(int i=0;i<=5;i++){
				System.out.println(Thread.currentThread().getName()+"进攻了["+i+"]");
				//让出处理器时间，下次该谁作战还不一定
				Thread.yield();
			}	
			
			System.out.println(Thread.currentThread().getName()+"进攻结束");
		}
		
	}
	

}
