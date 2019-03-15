package com.lyl.thread.base;
/**
 * 隋唐演义大舞台
 * @author Administrator
 *
 */
public class Stage extends Thread {

	public void run(){
		
		System.out.println("演出开始");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArmyRunnable armyTaskOfSuiDynasty=new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt=new ArmyRunnable();
		//使用Runnable接口创建线程
		Thread armyOfSuiDynasty=new Thread(armyTaskOfSuiDynasty,"隋军");
		Thread armyOfRevolt=new Thread(armyTaskOfRevolt,"农民起义军");
		
		//启动线程，让军队作战
		armyOfSuiDynasty.start();
		armyOfRevolt.start();
		
		try {
			//舞台线程休眠，大家专心观看军队厮杀
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("正当双方激战时，半路杀出了程咬金！");
		Thread mrCheng=new KeyPersonThread();
		mrCheng.setName("程咬金");
		System.out.println("程咬金的理想生活就是停止战争，使百姓安居乐业");
		//军队停止作战
		//停止线程
		armyTaskOfSuiDynasty.keepRunning=false;
		armyTaskOfRevolt.keepRunning=false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//历史大戏留给关键人物
		mrCheng.start();
		//万众瞩目，所有线程等待程先生完成历史使命
		try {
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("程先生完成历史使命！");
		System.out.println("演出结束，演员离场。");
//1.		
//		armyTaskOfSuiDynasty.keepRunning=false;
//		armyTaskOfRevolt.keepRunning=false;
//		try {
//			armyOfRevolt.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public static void main(String[] args) {
		new Stage().start();
	}
}
