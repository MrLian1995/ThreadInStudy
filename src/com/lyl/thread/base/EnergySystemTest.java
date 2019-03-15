package com.lyl.thread.base;

public class EnergySystemTest {

	//�����������������ӵĸ���
	private static final int BOX_AMOUNT=100;
	//ÿ�����ӵĳ�ʼ����
	private static final double INITIAL_ENERGY=1000;
	
	public static void main(String[] args) {
		EnergySystem eng=new EnergySystem(BOX_AMOUNT, INITIAL_ENERGY);
		for (int i = 0; i < BOX_AMOUNT; i++) {
			EnergyTransferTask task=new EnergyTransferTask(eng, i, INITIAL_ENERGY);
			Thread t=new Thread(task,"TrnsferThread_"+i);
			t.start();
		}
	}
}
