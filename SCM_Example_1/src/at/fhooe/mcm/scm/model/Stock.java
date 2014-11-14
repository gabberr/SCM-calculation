package at.fhooe.mcm.scm.model;

import java.util.ArrayList;

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
	ArrayList<Order> placedOrders = new ArrayList<Order>();
	
	public Stock(){
		iteration = 0;
	}
	
	public void iterate(){
		//checkRequiredOrders();
		
		iteration ++;
	}
	public void restock(){
		for 
	}
	public void placeOrder(int partId, int ammount) {
		
		switch (partId) {
		case 1:
			Order o1 = new Order(iteration + reorderTimePart1, partId, ammount);
			placedOrders.add(o1);
			break;
		case 2:
			Order o2 = new Order(iteration + reorderTimePart2, partId, ammount);
			placedOrders.add(o2);
			break;
		case 3:
			Order o3 = new Order(iteration + reorderTimePart3, partId, ammount);
			placedOrders.add(o3);
			break;
		case 4:
			Order o4 = new Order(iteration + reorderTimePart4, partId, ammount);
			placedOrders.add(o4);
			break;
		case 5:
			Order o5 = new Order(iteration + reorderTimePart5, partId, ammount);
			placedOrders.add(o5);
			break;

		default:
			break;
		}

	}
	private class Order {
		int weekOfDelivery;
		int partId;
		int ammount;
		public Order(int weekOfDelivery, int partId, int ammount) {
			super();
			this.weekOfDelivery = weekOfDelivery;
			this.partId = partId;
			this.ammount = ammount;
		}
		public boolean isCurrentWeek(int week) {
			return week == weekOfDelivery;
		}
	}
	
}
