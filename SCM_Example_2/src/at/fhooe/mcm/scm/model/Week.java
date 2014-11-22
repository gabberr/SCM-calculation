package at.fhooe.mcm.scm.model;

import java.util.ArrayList;

public class Week {

	ArrayList<ProductIF> products = new ArrayList();
	ProductIF proA = new ProductA();
	ProductIF proB = new ProductB();;
	ProductIF proC = new ProductC();;
	ProductIF proD = new ProductD();;
	ProductIF proE = new ProductE();;

	public int nOfA;
	public int nOfB;
	public int nOfC;
	public int nOfD;
	public int nOfE;
	
	String weekName = "";
	
	public Week(String name, int nOfA, int nOfB, int nOfC, int nOfD, int nOfE) {
		weekName = name;
		products.add(proA);
		products.add(proB);
		products.add(proC);
		products.add(proD);
		products.add(proE);
		this.nOfA = nOfA;
		this.nOfB = nOfB;
		this.nOfC = nOfC;
		this.nOfD = nOfD;
		this.nOfE = nOfE;
	}

	public Week() {
		products.add(proA);
		products.add(proB);
		products.add(proC);
		products.add(proD);
		products.add(proE);
	}

	public int getTotalP1(){

		return nOfA* proA.getP1() 
			+ nOfB * proB.getP1()
			+ nOfC * proC.getP1()
			+ nOfD * proD.getP1()
			+ nOfE * proE.getP1();
		
	}
	public int getTotalP2(){
		return nOfA* proA.getP2() 
				+ nOfB * proB.getP2()
				+ nOfC * proC.getP2()
				+ nOfD * proD.getP2()
				+ nOfE * proE.getP2();
	}
	public int getTotalP3(){
		return nOfA* proA.getP3() 
				+ nOfB * proB.getP3()
				+ nOfC * proC.getP3()
				+ nOfD * proD.getP3()
				+ nOfE * proE.getP3();
	}
	public int getTotalP4(){
		return nOfA* proA.getP4() 
				+ nOfB * proB.getP4()
				+ nOfC * proC.getP4()
				+ nOfD * proD.getP4()
				+ nOfE * proE.getP4();
	}
	public int getTotalP5(){
		return nOfA* proA.getP5() 
				+ nOfB * proB.getP5()
				+ nOfC * proC.getP5()
				+ nOfD * proD.getP5()
				+ nOfE * proE.getP5();
	}
	public void printWeekOrderByParts() {
		System.out.println(weekName + " P1: " +getTotalP1() +
				" P2: "+ getTotalP2()+
				" P3: "+ getTotalP3()+
				" P4: "+ getTotalP4()+
				" P5: "+ getTotalP5());
		
		
	}

}
