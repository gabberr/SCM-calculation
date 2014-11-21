package at.fhooe.mcm.scm;

import java.util.ArrayList;

import at.fhooe.mcm.scm.model.Stock;
import at.fhooe.mcm.scm.model.Week;

/**
 * Calculation class for stock order estimation
 * @author Koller/Gaber
 *
 */
public class Calculation {

	public Parser p = new Parser();
	public int nOfP1 = 216;
	public int nOfP2 = 245;
	public int nOfP3 = 158;
	public int nOfP4 = 180;
	public int nOfP5 = 149;
	
	public static int reorderTimePart1 = 1;
	public static int reorderTimePart2 = 2;
	public static int reorderTimePart3 = 2;
	public static int reorderTimePart4 = 3;
	public static int reorderTimePart5 = 1;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Parser p = new Parser();
		
		//initialize stock
		Stock s = new Stock(59);
		//place initial orders
		s.placeOrder(3,100);
		s.placeOrder(4,140);
		ArrayList<Week> weeks = p.parseObjects();
		ArrayList<Week> inputWeeks = p.parseObjects();
		
		int i = 0;
		while(i < inputWeeks.size()){			
			s.restock();
			//check if out of stock
			if(s.outOfStock()){
				System.out.println("Out of stock");
				break;
			}
			//produce orders
			
//			s.produce(inputWeeks.get(i));
			s.iterate();
			//estimate
			
			i++;	
		}
		System.out.println("Over");
	}
	
	public void estimateOrders(int partId){
		
	}
//	
//	public void calculation(){
//		ArrayList<Week> weeks = p.parseObjects();
//		int i = 0;
//		while(nOfP1>0 && nOfP2>0 && nOfP3>0 && nOfP4>0 && nOfP5>0){
//			nOfP1 -= weeks.get(i).getTotalP1();
//			nOfP2 -= weeks.get(i).getTotalP2();
//			nOfP3 -= weeks.get(i).getTotalP3();
//			nOfP4 -= weeks.get(i).getTotalP4();
//			nOfP5 -= weeks.get(i).getTotalP5();
//			System.out.println(nOfP1 + " ; " + nOfP2 + " ; " + nOfP3 + " ; " + nOfP4 + " ; " +nOfP5);
//			i++;
//		}
//		System.out.println("Over");
//	}
}
