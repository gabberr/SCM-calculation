package at.fhooe.mcm.scm.model;

import java.util.ArrayList;
import java.util.List;

import at.fhooe.mcm.scm.model.part.PartFive;
import at.fhooe.mcm.scm.model.part.PartFour;
import at.fhooe.mcm.scm.model.part.PartOne;
import at.fhooe.mcm.scm.model.part.PartThree;
import at.fhooe.mcm.scm.model.part.PartTwo;
import at.fhooe.mcm.scm.model.run.RunIF;
import at.fhooe.mcm.scm.model.run.RunLL;
import at.fhooe.mcm.scm.model.run.RunLS;
import at.fhooe.mcm.scm.model.run.RunSS;
import at.fhooe.mcm.scm.model.totes.ToteBig;
import at.fhooe.mcm.scm.model.totes.ToteIF;
import at.fhooe.mcm.scm.model.totes.ToteSmall;

public class Stock {

	public int iteration;
	
	private ArrayList<ToteIF> totesBig = new ArrayList<ToteIF>();
	private ArrayList<ToteIF> totesSmall = new ArrayList<ToteIF>();
	
	// weekly variables
	
	double nOfp1 = 0;
	double nOfp2 = 0;
	double nOfp3 = 0;
	double nOfp4 = 0;
	double nOfp5 = 0;
	
	private int totalSmall =0;
	private int totalBig =0;
	
	public int totalRunTime=0;
	
	PartOne p1 = new PartOne();
	PartTwo p2 = new PartTwo();
	PartThree p3 = new PartThree();
	PartFour p4 = new PartFour();
	PartFive p5 = new PartFive();
	
	public Stock(){
		iteration = 0;
	}
	public Stock(int initWeek){
		iteration = initWeek;
	}
	
	public void iterate(){
		//checkRequiredOrders();
		iteration++;
		totesBig.clear();
		totesSmall.clear();
	
	}
	public void initializeParts(Week w) {
		nOfp1 = Math.ceil(w.getTotalP1() /5.0);
		nOfp2 = Math.ceil(w.getTotalP2() /5.0);
		nOfp3 = Math.ceil(w.getTotalP3() /5.0);
		nOfp4 = Math.ceil(w.getTotalP4() /5.0);
		nOfp5 = Math.ceil(w.getTotalP5() /5.0);
	}
	
	public void calculatTotesRequiered() {
		
		
		double nOfp1Left = nOfp1;
		double nOfp2Left = nOfp2;
		double nOfp3Left = nOfp3;
		double nOfp4Left = nOfp4;
		double nOfp5Left = nOfp5;
		ToteBig big;
		ToteSmall small;
		boolean over = false;
		while(!over) {
			
			big = new ToteBig();
			while( big.isAddable(p1) && nOfp1Left>0 ) {
				big.addPart(p1);
				nOfp1Left--;
			}
			
			while( big.isAddable(p3) && nOfp3Left>0 ) {
				big.addPart(p3);
				nOfp3Left--;
			}
			totesBig.add(big);
			
			if( nOfp1Left == 0 && nOfp3Left == 0 ) {
				over = true;
			}
			
		}
		
		for(int i=0; i< totesBig.size(); i++) {
			while( totesBig.get(i).isAddable(p5) && nOfp5Left>0 ) {
				totesBig.get(i).addPart(p5);
				nOfp5Left--;
			}
			while( totesBig.get(i).isAddable(p2) && nOfp2Left>0 ) {
				totesBig.get(i).addPart(p2);
				nOfp2Left--;
			}
			while( totesBig.get(i).isAddable(p4) && nOfp4Left>0 ) {
				totesBig.get(i).addPart(p4);
				nOfp4Left--;
			}
			
		}
		over = false;
		while(!over) {
			small = new ToteSmall();
			while( small.isAddable(p5) && nOfp5Left>0 ) {
				small.addPart(p5);
				nOfp5Left--;
			}
			while( small.isAddable(p2) && nOfp2Left>0 ) {
				small.addPart(p2);
				nOfp2Left--;
			}
			while( small.isAddable(p4) && nOfp4Left>0 ) {
				small.addPart(p4);
				nOfp4Left--;
			}

			totesSmall.add(small);
			
			if( nOfp2Left <= 0 && nOfp4Left <= 0 && nOfp5Left <= 0) {
				over = true;
			}
			
		}
//		System.out.println(""+nOfp1Left + " "+ nOfp2Left + " "+nOfp3Left + " "+nOfp4Left +" "+nOfp5Left);
		
		totalBig += totesBig.size() * 5;
		totalSmall += totesSmall.size() * 5;
		
		System.out.println("Big totes used:" + totesBig.size()); // per day!
		System.out.println("Small totes used:" + totesSmall.size());
		for (int i = 0; i < totesBig.size(); i++) {
			totesBig.get(i).printToteParts();
		}
		for (int i = 0; i < totesSmall.size(); i++) {
			totesSmall.get(i).printToteParts();
		}
		totesToRuns();
		
		
		
		
	}
	public void totesToRuns(){
		
//		totesBig
//		totesSmall
		ArrayList<RunIF> runs = new ArrayList<RunIF>();
		RunLL big;
		RunSS small;
		RunLS mixed;
		boolean over = false;
		
			while(totesBig.size() > 1) {
				big = new RunLL( ( ToteBig) totesBig.get(0), ( ToteBig)  totesBig.get(1));
				totesBig.remove(0);
				totesBig.remove(0);
				runs.add(big);
				
			}
			// 
			if(totesBig.size() == 1) {
				mixed = new RunLS(( ToteBig)totesBig.get(0));
				totesBig.remove(0);
				while ( mixed.isAddable() && totesSmall.size() >0) {
					mixed.addSmallTote((ToteSmall) totesSmall.remove(0));
				}
				runs.add(mixed);
				
			}

			while (totesSmall.size() > 0) {
				small = new RunSS();
				while ( small.isAddable() && totesSmall.size() >0) {
					small.addSmallTote((ToteSmall) totesSmall.remove(0));
				}
				runs.add(small);
				
			}
		
			System.out.println("Big totes size :" + totesBig.size());
			System.out.println("Small totes size : " + totesSmall.size());
		
			int total = 0;
			for (int i = 0; i < runs.size(); i++) {
				total +=runs.get(i).getTotalTime();
				System.out.println("Run : " + runs.get(i).getPartPath().toString());
				System.out.println("Run cost per day this week : " + runs.get(i).getTotalTime());
				
			}
			totalRunTime += total*5;
			System.out.println("Runs per day this week : " + runs.size());
			System.out.println("Pick time of the week : " + total * 5);
		
	}
	
	
	public void printTotal() {
		System.out.println("Big totes used:" + totalBig);
		System.out.println("Small totes used: " + totalSmall);
		System.out.println("Total time of picking " + totalRunTime + "seconds");
	}
	
	
	public double getTotalRequieredVolume() {
		return p1.getVolume() * nOfp1
			+ 	p2.getVolume() * nOfp2
			+	p3.getVolume() * nOfp3
			+ 	p4.getVolume() * nOfp4
			+ p5.getVolume() * nOfp5;
	}
//	public ArrayList<Costs> allCost = new ArrayList<Stock.Costs>();
//	public void costManagement(int weekNumber){
//		Costs costs = new Costs();
//
//		allCost.add(costs);	
//	}
//	
	
	private class Costs {
		double earnings;
		double costs;
		int nOfNotDelivered;
		double profit;
		
		private double calculateProfit(int soldProducts, int purchasedParts, int nOfPartsOnStock, int nOfNotDelivered_, int nOfDifferentPartsDelivered){
			nOfNotDelivered = nOfNotDelivered_;
			profit = calculateEarnings(soldProducts) - calculateCosts( purchasedParts, nOfPartsOnStock, nOfNotDelivered, nOfDifferentPartsDelivered);
			
			return profit;
		}
		
		private double calculateEarnings(int soldProducts){
			earnings = soldProducts * 6;
			return earnings;
		}
		
		private double calculateCosts(int purchasedParts, int nOfPartsOnStock, int nOfNotDelivered, int nOfDifferentPartsDelivered){
			costs = (purchasedParts * 0.8) + nOfPartsOnStock + (nOfNotDelivered * 10) + (nOfDifferentPartsDelivered);
			return costs;
		}
		
		private void printData(int weekNumber){
			System.out.println("Results for week: " + weekNumber + " Earnings: " + earnings + "; Costs: " + costs + "; No delivered " + nOfNotDelivered + "; Profit " + profit);
		}
	}
	
}
