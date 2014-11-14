package at.fhooe.mcm.scm.model;

import java.io.Console;
import java.util.ArrayList;

public class Week {

	ArrayList<ProductIF> products = new ArrayList();
	ProductIF proA = new ProductA();
	ProductIF proB = new ProductB();;
	ProductIF proC = new ProductC();;
	ProductIF proD = new ProductD();;
	ProductIF proE = new ProductE();;

	int nOfA;
	int nOfB;
	int nOfC;
	int nOfD;
	int nOfE;
	
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
		int sum = 0;
		for(int i = 0; i < products.size(); i++){
			sum += products.get(i).getP1();
		}
		return sum;
	}
	public int getTotalP2(){
		int sum = 0;
		for(int i = 0; i < products.size(); i++){
			sum += products.get(i).getP2();
		}
		return sum;
	}
	public int getTotalP3(){
		int sum = 0;
		for(int i = 0; i < products.size(); i++){
			sum += products.get(i).getP3();
		}
		return sum;
	}
	public int getTotalP4(){
		int sum = 0;
		for(int i = 0; i < products.size(); i++){
			sum += products.get(i).getP4();
		}
		return sum;
	}
	public int getTotalP5(){
		int sum = 0;
		for(int i = 0; i < products.size(); i++){
			sum += products.get(i).getP5();
		}
		return sum;
	}
	public void printWeekOrderByParts() {
		System.out.println(weekName + " P1: " +getTotalP1() +
				" P2: "+ getTotalP2()+
				" P3: "+ getTotalP3()+
				" P4: "+ getTotalP4()+
				" P5: "+ getTotalP5());
		
		
	}

}
