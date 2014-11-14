package at.fhooe.mcm.scm.model;

public class Stock {

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
	
	public int iteration;
	
	public Stock(){
		iteration = 0;
	}
	
	public void iterate(){
		//checkRequiredOrders();
		
		iteration ++;
	}
	
	
}
