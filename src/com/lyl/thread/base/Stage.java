package com.lyl.thread.base;
/**
 * �����������̨
 * @author Administrator
 *
 */
public class Stage extends Thread {

	public void run(){
		
		System.out.println("�ݳ���ʼ");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArmyRunnable armyTaskOfSuiDynasty=new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt=new ArmyRunnable();
		//ʹ��Runnable�ӿڴ����߳�
		Thread armyOfSuiDynasty=new Thread(armyTaskOfSuiDynasty,"���");
		Thread armyOfRevolt=new Thread(armyTaskOfRevolt,"ũ�������");
		
		//�����̣߳��þ�����ս
		armyOfSuiDynasty.start();
		armyOfRevolt.start();
		
		try {
			//��̨�߳����ߣ����ר�Ĺۿ�������ɱ
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("����˫����սʱ����·ɱ���˳�ҧ��");
		Thread mrCheng=new KeyPersonThread();
		mrCheng.setName("��ҧ��");
		System.out.println("��ҧ��������������ֹͣս����ʹ���հ�����ҵ");
		//����ֹͣ��ս
		//ֹͣ�߳�
		armyTaskOfSuiDynasty.keepRunning=false;
		armyTaskOfRevolt.keepRunning=false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ʷ��Ϸ�����ؼ�����
		mrCheng.start();
		//������Ŀ�������̵߳ȴ������������ʷʹ��
		try {
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�����������ʷʹ����");
		System.out.println("�ݳ���������Ա�볡��");
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
