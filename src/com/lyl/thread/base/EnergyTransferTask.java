package com.lyl.thread.base;

public class EnergyTransferTask extends Thread {

	//共享的能量世界
	private EnergySystem energySystem;
	//能量盒子下标
	private int fromBox;
	//单次转移最大能量
	private double maxAmount;
	//最大休眠时间
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
