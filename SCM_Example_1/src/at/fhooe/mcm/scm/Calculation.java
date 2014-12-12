package at.fhooe.mcm.scm;

import java.awt.List;
import java.util.ArrayList;

import at.fhooe.mcm.scm.model.ProductA;
import at.fhooe.mcm.scm.model.ProductB;
import at.fhooe.mcm.scm.model.ProductC;
import at.fhooe.mcm.scm.model.ProductD;
import at.fhooe.mcm.scm.model.ProductE;
import at.fhooe.mcm.scm.model.Stock;
import at.fhooe.mcm.scm.model.Week;

/**
 * Calculation class for stock order estimation
 * @author Koller/Setina
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
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ProductA a = new ProductA();
		ProductB b = new ProductB();
		ProductC c = new ProductC();
		ProductD d = new ProductD();
		ProductE e = new ProductE();
		
		Parser p = new Parser();
		
		//initialize stock
		Stock s = new Stock(59);
		//place initial orders
		s.placeOrder(3,100);
		s.placeOrder(4,140);
		s.iterate();
		ArrayList<Week> inputWeeks = p.parseObjects();
		ArrayList<Week> estimationList;
		
		int i = 60;
		while(i < inputWeeks.size()){
			
			
			s.iterate();
			System.out.println("      ");
			System.out.println("----- New week -----");
			s.printStock();
			int missed = 0;
			missed += s.produceProductOfQuantity(c, inputWeeks.get(i).nOfC );
			missed += s.produceProductOfQuantity(a, inputWeeks.get(i).nOfA );
			missed += s.produceProductOfQuantity(b, inputWeeks.get(i).nOfB );
			missed += s.produceProductOfQuantity(d, inputWeeks.get(i).nOfD );
			missed += s.produceProductOfQuantity(e, inputWeeks.get(i).nOfE );
			
			System.out.println("					Couldn't be produced: " + missed);
			System.out.println("----- Stock after -----");
			s.printStock();
//			LOG("Couldnt produce: " +missed);
			

			estimationList = new ArrayList<Week>(inputWeeks.subList(s.iteration-3, s.iteration-1));
			//estimate
			s.estimateOrders(estimationList);
			i++;
			s.costManagement(i);
			System.out.println(" Total not delivered" + s.totalNotDeliveredProducts);
			
		}
		s.printTotalCosts();
		System.out.println("Over");
	}
	
	public void estimateOrders(int partId){
		
	}

}
