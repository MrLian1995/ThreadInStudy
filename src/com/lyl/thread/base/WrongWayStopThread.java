package com.lyl.thread.base;

public class WrongWayStopThread extends Thread{

	public static void main(String[] args) {
		WrongWayStopThread thread=new WrongWayStopThread();
		System.out.println("Strarting Thread....");
		thread.start();
		try {
			thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Interrupting thread...");
		thread.interrupt();//�ж��߳�
		try {
			thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Stopping application...");  
		
	}
	
	public void run() {
		while(!this.isInterrupted()){
			
			System.out.println("Thread is running...");
//			long time=System.currentTimeMillis();
//			while(System.currentTimeMillis()-time<1000){
//				//������Ļ����Ŀ�ѭ��
//			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
