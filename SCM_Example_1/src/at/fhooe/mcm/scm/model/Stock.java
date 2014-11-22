package at.fhooe.mcm.scm.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Stock {

	public int nOfP1 = 216;
	public int nOfP2 = 245;
	public int nOfP3 = 158;
	public int nOfP4 = 180;
	public int nOfP5 = 149;
	
	//weekly variables
	public int producedProducts;
	public int notDeliveredProducts;
	public int purchasedParts;
	public int partsDeliveryCosts;
	
	public static int reorderTimePart1 = 1;
	public static int reorderTimePart2 = 2;
	public static int reorderTimePart3 = 2;
	public static int reorderTimePart4 = 3;
	public static int reorderTimePart5 = 1;
	
	public int iteration;
	// these are the orders for parts, not to be confused with week orders of products
	ArrayList<Order> placedOrders = new ArrayList<Order>();
	
	public Stock(){
		iteration = 0;
	}
	public Stock(int initWeek){
		iteration = initWeek;
	}
	
	public void iterate(){
		//checkRequiredOrders();
		iteration++;
		
		//re-init calc variables
		producedProducts = 0;
		notDeliveredProducts=0;
		purchasedParts = 0;
		partsDeliveryCosts = 0;
		restock();
		
	}
	
	public boolean outOfStock(){
		if(nOfP1 < 0 || nOfP2 < 0 || nOfP3 < 0 || nOfP4 < 0 || nOfP5 <0){
			return false;
		}else{
			return true;
		}
	}
	
	public void estimateOrders(ArrayList<Week> weekList){
		
		ProductA a = new ProductA();
		ProductB b = new ProductB();
		ProductC c = new ProductC();
		ProductD d = new ProductD();
		ProductE e = new ProductE();
		
		
		double averageProductA = 0;
		double averageProductB = 0;
		double averageProductC = 0;
		double averageProductD = 0;
		double averageProductE = 0;
		
		/*
		 * How many product were ordered weekly
		 */
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
		
		/*
		 * How many of Px we needed peer week on average to fulfill the product orders
		 */
		double averagePart1 = 0;
		double averagePart2 = 0;
		double averagePart3 = 0;
		double averagePart4 = 0;
		double averagePart5 = 0;
		
		for(int i = 0; i < weekList.size(); i++){
			Week w = weekList.get(i);	
			averagePart1 += w.nOfA * a.getP1() + w.nOfB * b.getP1() + w.nOfC * c.getP1() + w.nOfD * d.getP1() + w.nOfE * e.getP1();
			averagePart2 += w.nOfA * a.getP2() + w.nOfB * b.getP2() + w.nOfC * c.getP2() + w.nOfD * d.getP2() + w.nOfE * e.getP2();
			averagePart3 += w.nOfA * a.getP3() + w.nOfB * b.getP3() + w.nOfC * c.getP3() + w.nOfD * d.getP3() + w.nOfE * e.getP3();
			averagePart4 += w.nOfA * a.getP4() + w.nOfB * b.getP4() + w.nOfC * c.getP4() + w.nOfD * d.getP4() + w.nOfE * e.getP4();
			averagePart5 += w.nOfA * a.getP5() + w.nOfB * b.getP5() + w.nOfC * c.getP5() + w.nOfD * d.getP5() + w.nOfE * e.getP5();
		}
		averagePart1 /= weekList.size();
		averagePart2 /= weekList.size();
		averagePart3 /= weekList.size();
		averagePart4 /= weekList.size();
		averagePart5 /= weekList.size();
		
		
		// using the product average to calculate the parts needed
		int orderP1=0, orderP2=0, orderP3=0, orderP4=0, orderP5 = 0;
		
		orderP1 += averageProductA;
		orderP1 += averageProductB * 2;
		orderP1 += averageProductD * 3;
		orderP1 += averageProductE;
		
		orderP2 += averageProductC * 3;
		orderP2 += averageProductE * 2;
		
		orderP3 += averageProductA;
		orderP3 += averageProductB;
		orderP3 += averageProductD;
		
		orderP4 += averageProductA * 2;
		orderP4 += averageProductC;
		orderP4 += averageProductE * 2;
		
		orderP5 += averageProductB;
		orderP5 += averageProductD * 2;
		orderP5 += averageProductE * 2;
		
		
		
		
		if(iteration<70) {
//			if(nOfP1 < averagePart1 + getTotalPlacedPart(1))
//				placeOrder(1, orderP1);
//			if(nOfP2 < averagePart2 + getTotalPlacedPart(2))
//				placeOrder(2, orderP2 );
//			if(nOfP3 < averagePart3 + getTotalPlacedPart(3))
//				placeOrder(3, orderP3 );
//			if(nOfP4 < averagePart4 + getTotalPlacedPart(4))
//				placeOrder(4, orderP4 );
//			if(nOfP5 < averagePart5 + getTotalPlacedPart(5))
//				placeOrder(5, orderP5);
		
		if(nOfP1 < averagePart1 + getTotalPlacedPart(1))
			placeOrder(1, (int) (averagePart1));
		if(nOfP2 < averagePart2 + getTotalPlacedPart(2))
			placeOrder(2, (int) (averagePart2) );
		if(nOfP3 < averagePart3 + getTotalPlacedPart(3))
			placeOrder(3, (int) (averagePart3) );
		if(nOfP4 < averagePart4 + getTotalPlacedPart(4))
			placeOrder(4, (int) (averagePart4) );
		if(nOfP5 < averagePart5 + getTotalPlacedPart(5))
			placeOrder(5, (int) (averagePart5) );
		}
		

		
//		if(!isProductProducableByNumberOfProducts((int)averageProductA,a)){
//			placeOrder(1, (int)averageProductA - getTotalPlacedPart(1));
//			placeOrder(3, (int)averageProductA - getTotalPlacedPart(3));
//			placeOrder(4, (int)averageProductA*2 - getTotalPlacedPart(4));
////			placeOrder(1, (int)averageProductA);
////			placeOrder(3, (int)averageProductA);
////			placeOrder(4, (int)averageProductA*2);
//		}
//		if(!isProductProducableByNumberOfProducts((int)averageProductB,b)){
//			placeOrder(1, (int)averageProductB*2 - getTotalPlacedPart(1));
//			placeOrder(3, (int)averageProductB - getTotalPlacedPart(3));
//			placeOrder(5, (int)averageProductB - getTotalPlacedPart(5));
////			placeOrder(1, (int)averageProductB*2);
////			placeOrder(3, (int)averageProductB);
////			placeOrder(5, (int)averageProductB);
//		}
//		if(!isProductProducableByNumberOfProducts((int)averageProductC,c)){
//			placeOrder(2, (int)averageProductC*3 - getTotalPlacedPart(2));
//			placeOrder(4, (int)averageProductC - getTotalPlacedPart(4));
////			placeOrder(2, (int)averageProductC*3);
////			placeOrder(4, (int)averageProductC);
//		}
//		if(!isProductProducableByNumberOfProducts((int)averageProductD,d)){
//			placeOrder(1, (int)averageProductD*3 - getTotalPlacedPart(1));
//			placeOrder(3, (int)averageProductD - getTotalPlacedPart(3));
//			placeOrder(5, (int)averageProductD*2 - getTotalPlacedPart(5));
////			placeOrder(1, (int)averageProductD*3);
////			placeOrder(3, (int)averageProductD);
////			placeOrder(5, (int)averageProductD*2);
//		}
//		if(!isProductProducableByNumberOfProducts((int)averageProductE,e)){
//			placeOrder(1, (int)averageProductE - getTotalPlacedPart(1));
//			placeOrder(2, (int)averageProductE*2 - getTotalPlacedPart(2));
//			placeOrder(4, (int)averageProductE*2 - getTotalPlacedPart(4));
//			placeOrder(5, (int)averageProductE*2 - getTotalPlacedPart(5));
////			placeOrder(1, (int)averageProductE);
////			placeOrder(2, (int)averageProductE*2);
////			placeOrder(4, (int)averageProductE*2);
////			placeOrder(5, (int)averageProductE*2);
//		}
	}
	
	/* 
	 * calculate the total of Px that are already placed in an order for the stock
	 */
	public int getTotalPlacedPart(int partId) {
		int n = 0;
		for(int z = 0; z < placedOrders.size(); z++){
			if(placedOrders.get(z).partId == partId)
				n+= placedOrders.get(z).amount;
		}
		return n;
	}
	
	/*
	 * Can we produce all of the products for the week order ( parts needed are in stock)
	 */
	public boolean isAllProducable(Week weekOrder) {
		
		int totalP1 = weekOrder.getTotalP1();
		int totalP2 = weekOrder.getTotalP2();
		int totalP3 = weekOrder.getTotalP3();
		int totalP4 = weekOrder.getTotalP4();
		int totalP5 = weekOrder.getTotalP5();
		
		
			
		return     totalP1 <= nOfP1
				&& totalP2 <= nOfP2
				&& totalP3 <= nOfP3
				&& totalP4 <= nOfP4
				&& totalP5 <= nOfP5;
	}
	
	/*
	 * All products of same type in week
	 */
	public boolean isProductProducableByNumberOfProducts(int nOfProducts, ProductIF p) {
		int N  = nOfProducts;
		return	   N * p.getP1() <= nOfP1 + getTotalPlacedPart(1) 
				&& N * p.getP2() <= nOfP2 + getTotalPlacedPart(2) 
				&& N * p.getP3() <= nOfP3 + getTotalPlacedPart(3) 
				&& N * p.getP4() <= nOfP4 + getTotalPlacedPart(4) 
				&& N * p.getP5() <= nOfP5 + getTotalPlacedPart(5) ;
	}
	
	/*
	 * All products of same type in week
	 */
	public boolean isProductProducable(Week weekOrder, ProductIF p) {
		int N  = weekOrder.nOfA;
		return	   N * p.getP1() <= nOfP1
				&& N * p.getP2() <= nOfP2
				&& N * p.getP3() <= nOfP3
				&& N * p.getP4() <= nOfP4
				&& N * p.getP5() <= nOfP5;
	}
	/*
	 * A single product
	 */
	public boolean isSingleProductProducable(ProductIF p) {
		return     p.getP1() <= nOfP1
				&& p.getP2() <= nOfP2
				&& p.getP3() <= nOfP3
				&& p.getP4() <= nOfP4
				&& p.getP5() <= nOfP5;
	}
	
	public void restock(){
		
		boolean orderedP1 = false;
		boolean orderedP2 = false;
		boolean orderedP3 = false;
		boolean orderedP4 = false;
		boolean orderedP5 = false;
		
		for(int z = 0; z < placedOrders.size(); z++){
			if(placedOrders.get(z).isCurrentWeek(iteration)){
				switch (placedOrders.get(z).partId) {
				case 1:
					nOfP1+= placedOrders.get(z).amount;
					purchasedParts += placedOrders.get(z).amount;
					LOG("Parts P1 added to stock :  "+ placedOrders.get(z).amount );
					placedOrders.get(z).amount=0;
					orderedP1 = true;
					break;
				case 2:
					nOfP2+= placedOrders.get(z).amount;
					purchasedParts += placedOrders.get(z).amount;
					LOG("Parts P2 added to stock: "+ placedOrders.get(z).amount );
					placedOrders.get(z).amount=0;
					orderedP2 = true;
					break;
				case 3:
					nOfP3+= placedOrders.get(z).amount;
					purchasedParts += placedOrders.get(z).amount;
					LOG("Parts P3 added to stock: "+ placedOrders.get(z).amount );
					placedOrders.get(z).amount=0;
					orderedP3 = true;
					break;
				case 4:
					nOfP4+= placedOrders.get(z).amount;
					purchasedParts += placedOrders.get(z).amount;
					LOG("Parts P4 added to stock"+ placedOrders.get(z).amount );
					placedOrders.get(z).amount=0;
					orderedP4 = true;
					break;
				case 5:
					nOfP5+= placedOrders.get(z).amount;
					purchasedParts += placedOrders.get(z).amount;
					LOG("Parts P5 added to stock:  "+ placedOrders.get(z).amount );
					placedOrders.get(z).amount=0;
					orderedP5 = true;
					break;
				}
			}
		}
		//add order costs for parts
		if(orderedP1){
			partsDeliveryCosts += 10;
		}
		if(orderedP2){
			partsDeliveryCosts += 10;
		}
		if(orderedP3){
			partsDeliveryCosts += 10;
		}
		if(orderedP4){
			partsDeliveryCosts += 10;
		}
		if(orderedP5){
			partsDeliveryCosts += 10;
		}
	}
	
	/*
	 * Produces whole week
	 */
	public void produceAll(Week w){
		LOG("Parts used for Production: " + "Week " + iteration + " Part 1:" + w.getTotalP1() + " Part 2: " + w.getTotalP2() + " Part 3: " + w.getTotalP3() + " Part 4: " + w.getTotalP4() + " Part 5: " + w.getTotalP5());
		
		nOfP1 -= w.getTotalP1();
		nOfP2 -= w.getTotalP2();
		nOfP3 -= w.getTotalP3();
		nOfP4 -= w.getTotalP4();
		nOfP5 -= w.getTotalP5();
		
		producedProducts = w.nOfA + w.nOfB+ w.nOfC + w.nOfD + w.nOfE;
		LOG("Products produced: " + "Week " + " ;ProA " + w.nOfA + " ;ProB " + w.nOfB + " ;ProC " + w.nOfC + " ;ProD " + w.nOfD + " ;ProE " + w.nOfE);
	}
	
	public void printStock(){
		System.out.println("Week " + iteration + " Stock:\n " + "P1: " + nOfP1 + "\n P2: " + nOfP2 + "\n P3: " + nOfP3 + "\n P4: " + nOfP4 + "\n P5: " + nOfP5);
	}
	
	/*
	 * Produces all products of same type
	 * returns the number of products that couldnt be produced
	 */
	public int produceProductOfQuantity(ProductIF p, int quantity) {
		int produced = 0;
		// until we can still produce and we didnt produced all quantity
		while( isSingleProductProducable(p) && produced < quantity) {
			nOfP1 -=  p.getP1();
			nOfP2 -=  p.getP2();
			nOfP3 -=  p.getP3();
			nOfP4 -=  p.getP4();
			nOfP5 -=  p.getP5();
			producedProducts++;
			produced++;
		}
		LOG("Produced product " + p.toString() + " :  "+produced + "/" + quantity);
		int notDelivered = quantity - produced;
		
		notDeliveredProducts += notDelivered;
		
		return notDelivered;
	}
	
	public void placeOrder(int partId, int ammount) {
		LOG("Order of P" + partId+" placed with ammount: " +ammount);
		
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
	public static void LOG(String text) {
		System.out.println(text);
	}
	private class Order {
		int weekOfDelivery;
		int partId;
		int amount;
		public Order(int weekOfDelivery, int partId, int ammount) {
			super();
			this.weekOfDelivery = weekOfDelivery;
			this.partId = partId;
			this.amount = ammount;
		}
		public boolean isCurrentWeek(int week) {
			return week == weekOfDelivery;
		}
	}
	
	public ArrayList<Costs> allCost = new ArrayList<Stock.Costs>();
	public void costManagement(int weekNumber){
		Costs costs = new Costs();
		int numberOfPartsOnStock = nOfP1 + nOfP2 + nOfP3 + nOfP4 + nOfP5;
		costs.calculateProfit(producedProducts, purchasedParts, numberOfPartsOnStock, notDeliveredProducts, partsDeliveryCosts);
		costs.printData(weekNumber);
		allCost.add(costs);	
	}
	public void printTotalCosts() {
		double earnings =0;
		double costs =0;
		int unsoldProducts=0;
		double profit=0;
		
		for (int i = 0; i < allCost.size(); i++) {
			Costs c = allCost.get(i);
			
			earnings += c.earnings;
			costs += c.costs;
			unsoldProducts += c.unsoldProducts;
			profit += c.profit;
			
		}
		System.out.println("Results Total: " + allCost.size() + " Earnings: " + earnings + "; Costs: " + costs + ";  Unsold Products " + unsoldProducts + "; Profit " + profit);
		
	}
	
	private class Costs {
		double earnings;
		double costs;
		int unsoldProducts;
		double profit;
		
		private double calculateProfit(int soldProducts, int purchasedParts, int nOfPartsOnStock, int nOfNotDelivered, int nOfDifferentPartsDelivered){
			profit = calculateEarnings(soldProducts) - calculateCosts( purchasedParts, nOfPartsOnStock, nOfNotDelivered, nOfDifferentPartsDelivered);
			unsoldProducts = nOfNotDelivered;
			return profit;
		}
		
		private double calculateEarnings(int soldProducts){
			earnings = soldProducts * 6;
			return earnings;
		}
		
		private double calculateCosts(int purchasedParts, int nOfPartsOnStock, int nOfNotDelivered, int nOfDifferentPartsDelivered){
			costs = (purchasedParts * 0.8) + nOfPartsOnStock + (nOfNotDelivered * 10) + (nOfDifferentPartsDelivered * 10);
			return costs;
		}
		
		private void printData(int weekNumber){
			System.out.println("Results for week: " + weekNumber + " Earnings: " + earnings + "; Costs: " + costs + "; Unsold Products " + unsoldProducts + "; Profit " + profit);
//			System.out.println("Results for week: " + weekNumber + " Earnings: " + earnings + "; Costs: " + costs + "; Profit " + profit + );
		}
	}
	
}
