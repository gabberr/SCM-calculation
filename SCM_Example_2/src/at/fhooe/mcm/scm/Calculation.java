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
		p.parseObjects();
		//initialize stock
		Stock s = new Stock(0);


		ArrayList<Week> inputWeeks = p.parseObjects();

//		
		int i = 0;
		while(i < inputWeeks.size()){
			s.iterate();
			s.initializeParts(inputWeeks.get(i));
			
			s.calculatTotesRequiered();
			
			System.out.println(i);

//			estimationList = new ArrayList<Week>(inputWeeks.subList(s.iteration-4, s.iteration-1));
			//estimate
//			s.estimateOrders(estimationList);
			i++;
//			s.costManagement(i);	
		}
		s.printTotal();
		
		System.out.println("Over");
	}
	
	public void estimateOrders(int partId){
		
	}

}
