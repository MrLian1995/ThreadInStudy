package com.lyl.thread.base;
/**
 * �����߳�
 * ģ����ս˫������Ϊ
 * @author Administrator
 *
 */
public class ArmyRunnable implements Runnable{

	//volatile��֤���߳̿�����ȷ��ȡ�����߳�д���ֵ
	//�ɼ��� ref JMM(java�ڴ�ģ��)  happens-beforeԭ��
	volatile boolean keepRunning=true;

	public void run() {
		while(keepRunning){
			for(int i=0;i<=5;i++){
				System.out.println(Thread.currentThread().getName()+"������["+i+"]");
				//�ó�������ʱ�䣬�´θ�˭��ս����һ��
				Thread.yield();
			}	
			
			System.out.println(Thread.currentThread().getName()+"��������");
		}
		
	}
	

}
