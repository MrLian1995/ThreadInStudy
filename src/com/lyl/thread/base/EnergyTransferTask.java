package com.lyl.thread.base;

public class EnergyTransferTask extends Thread {

	//�������������
	private EnergySystem energySystem;
	//���������±�
	private int fromBox;
	//����ת���������
	private double maxAmount;
	//�������ʱ��
	private int DELAY=10;
	public EnergyTransferTask(EnergySystem energySystem,int from,double max){
		this.energySystem=energySystem;
		this.fromBox=from;
		this.maxAmount=max;
	}
	
	@Override
	public void run() {
		try {
		while(true){
			int toBox=(int)(energySystem.getBoxAmount()*Math.random());
			double amount=maxAmount*Math.random();
			energySystem.transfer(fromBox, toBox, amount);
			Thread.sleep((int)(DELAY*Math.random()));
		}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
}
