package com.lyl.thread.base;
//能量系统
public class EnergySystem {

	//能量盒子，储存能量的地方
	private final double[] energyBoxes;
	//创建锁对象
	private final Object lockObj=new Object();
	/**
	 * 
	 * @param n：能量盒子数量
	 * @param intialEnergy：每个盒子的初始能量值
	 */
	public EnergySystem(int n,double intialEnergy){
		energyBoxes=new double[n];
		for(int i=0;i<energyBoxes.length;i++){
			energyBoxes[i]=intialEnergy;
		}
	}
	/**
	 * 能量从一个盒子转移到另一个盒子
	 * @param from ：能量源
	 * @param to：能量终点
	 * @param amount：能量值
	 */
	public void transfer(int from,int to,double amount){
		
		synchronized (lockObj) {
//			if(energyBoxes[from]<amount){	
//				return;
//			}
			//while循环，保证条件不满足时，任务都会被条件阻挡
			//而不是持续竞争CPU资源
			//Wait Set
			while(energyBoxes[from]<amount){
				try {
					lockObj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName());
			energyBoxes[from]-=amount;
			System.out.printf("从%d转移%10.2f单位能量到%d",from,amount,to);
			energyBoxes[to]+=amount;
			System.out.printf("能量总和：%10.2f%n",getTotalEnergies());
			//唤醒所有在lockObj对象上等待的线程
			lockObj.notifyAll();
		}
	}
	/**
	 * 获取能量世界能量的总和
	 * @return
	 */
	private double getTotalEnergies() {
		double sum=0;
		for(double amount:energyBoxes){
			sum+=amount;
		}
		
		return sum;
	}
	/**
	 * 获取能量盒子的长度
	 * @return
	 */
	public int getBoxAmount(){
		return energyBoxes.length;
	}
}
