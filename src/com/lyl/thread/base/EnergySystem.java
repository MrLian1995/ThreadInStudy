package com.lyl.thread.base;
//����ϵͳ
public class EnergySystem {

	//�������ӣ����������ĵط�
	private final double[] energyBoxes;
	//����������
	private final Object lockObj=new Object();
	/**
	 * 
	 * @param n��������������
	 * @param intialEnergy��ÿ�����ӵĳ�ʼ����ֵ
	 */
	public EnergySystem(int n,double intialEnergy){
		energyBoxes=new double[n];
		for(int i=0;i<energyBoxes.length;i++){
			energyBoxes[i]=intialEnergy;
		}
	}
	/**
	 * ������һ������ת�Ƶ���һ������
	 * @param from ������Դ
	 * @param to�������յ�
	 * @param amount������ֵ
	 */
	public void transfer(int from,int to,double amount){
		
		synchronized (lockObj) {
//			if(energyBoxes[from]<amount){	
//				return;
//			}
			//whileѭ������֤����������ʱ�����񶼻ᱻ�����赲
			//�����ǳ�������CPU��Դ
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
			System.out.printf("��%dת��%10.2f��λ������%d",from,amount,to);
			energyBoxes[to]+=amount;
			System.out.printf("�����ܺͣ�%10.2f%n",getTotalEnergies());
			//����������lockObj�����ϵȴ����߳�
			lockObj.notifyAll();
		}
	}
	/**
	 * ��ȡ���������������ܺ�
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
	 * ��ȡ�������ӵĳ���
	 * @return
	 */
	public int getBoxAmount(){
		return energyBoxes.length;
	}
}
