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
		iteration++;
	}
	
	public boolean outOfStock(){
		if(nOfP1 < 0 || nOfP2 < 0 || nOfP3 < 0 || nOfP4 < 0 || nOfP5 <0){
			return false;
		}else{
			return true;
		}
	}
	
	public void estimateOrders(ArrayList<Week> weekList){
		double averageProductA = 0;
		double averageProductB = 0;
		double averageProductC = 0;
		double averageProductD = 0;
		double averageProductE = 0;
		
		for(int i = 0; i < weekList.size(); i++){
			averageProductA += weekList.get(i).nOfA;
			averageProductB += weekList.get(i).nOfB;
			averageProductC += weekList.get(i).nOfC;
			averageProductD += weekList.get(i).nOfD;
			averageProductE += weekList.get(i).nOfE;
		}
		averageProductA /= weekList.size();
		averageProductB /= weekList.size();
		averageProductC /= weekList.size();
		averageProductD /= weekList.size();
		averageProductE /= weekList.size();
	}
	
	public void restock(){
		for(int z = 0; z < placedOrders.size(); z++){
			if(placedOrders.get(z).isCurrentWeek(iteration)){
				switch (placedOrders.get(z).partId) {
				case 1:
					nOfP1+= placedOrders.get(z).ammount;
					break;
				case 2:
					nOfP2+= placedOrders.get(z).ammount;
					break;
				case 3:
					nOfP3+= placedOrders.get(z).ammount;
					break;
				case 4:
					nOfP4+= placedOrders.get(z).ammount;
					break;
				case 5:
					nOfP5+= placedOrders.get(z).ammount;;
					break;
				}
			}
		}
	}
	
	public void produce(Week w){
		nOfP1 -= w.getTotalP1();
		nOfP2 -= w.getTotalP2();
		nOfP3 -= w.getTotalP3();
		nOfP4 -= w.getTotalP4();
		nOfP5 -= w.getTotalP5();
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
