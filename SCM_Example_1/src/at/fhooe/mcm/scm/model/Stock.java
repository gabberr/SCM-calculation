package at.fhooe.mcm.scm.model;

import java.util.ArrayList;

public class Stock {

	public int nOfP1 = 216;
	public int nOfP2 = 245;
	public int nOfP3 = 158;
	public int nOfP4 = 180;
	public int nOfP5 = 149;
	
	//weekly variables
	public int producedProducts;
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
		purchasedParts = 0;
		partsDeliveryCosts = 0;
		
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
		
		/* 
		 * what is the difference to the stock, do the products need to be reordered
		 */
		if(!isProductProducableByNumberOfProducts((int)averageProductA*3,a)){
//			placeOrder(1, (int)averageProductA - getTotalPlacedPart(1));
//			placeOrder(3, (int)averageProductA - getTotalPlacedPart(3));
//			placeOrder(4, (int)averageProductA*2 - getTotalPlacedPart(4));
			placeOrder(1, (int)averageProductA);
			placeOrder(3, (int)averageProductA);
			placeOrder(4, (int)averageProductA*2);
		}
		if(!isProductProducableByNumberOfProducts((int)averageProductB*2,b)){
//			placeOrder(1, (int)averageProductB*2 - getTotalPlacedPart(1));
//			placeOrder(3, (int)averageProductB - getTotalPlacedPart(3));
//			placeOrder(5, (int)averageProductB - getTotalPlacedPart(5));
			placeOrder(1, (int)averageProductB*2);
			placeOrder(3, (int)averageProductB);
			placeOrder(5, (int)averageProductB);
		}
		if(!isProductProducableByNumberOfProducts((int)averageProductC*3,c)){
//			placeOrder(2, (int)averageProductC*3 - getTotalPlacedPart(2));
//			placeOrder(4, (int)averageProductC - getTotalPlacedPart(4));
			placeOrder(2, (int)averageProductC*3);
			placeOrder(4, (int)averageProductC);
		}
		if(!isProductProducableByNumberOfProducts((int)averageProductD*2,d)){
//			placeOrder(1, (int)averageProductD*3 - getTotalPlacedPart(1));
//			placeOrder(3, (int)averageProductD - getTotalPlacedPart(3));
//			placeOrder(5, (int)averageProductD*2 - getTotalPlacedPart(5));
			placeOrder(1, (int)averageProductD*3);
			placeOrder(3, (int)averageProductD);
			placeOrder(5, (int)averageProductD*2);
		}
		if(!isProductProducableByNumberOfProducts((int)averageProductE*3,e)){
//			placeOrder(1, (int)averageProductE - getTotalPlacedPart(1));
//			placeOrder(2, (int)averageProductE*2 - getTotalPlacedPart(2));
//			placeOrder(4, (int)averageProductE*2 - getTotalPlacedPart(4));
//			placeOrder(5, (int)averageProductE*2 - getTotalPlacedPart(5));
			placeOrder(1, (int)averageProductE);
			placeOrder(2, (int)averageProductE*2);
			placeOrder(4, (int)averageProductE*2);
			placeOrder(5, (int)averageProductE*2);
		}
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
			
		return     weekOrder.getTotalP1() <= nOfP1
				&& weekOrder.getTotalP2() <= nOfP2
				&& weekOrder.getTotalP3() <= nOfP3
				&& weekOrder.getTotalP4() <= nOfP4
				&& weekOrder.getTotalP5() <= nOfP5;
	}
	
	/*
	 * All products of same type in week
	 */
	public boolean isProductProducableByNumberOfProducts(int nOfProducts, ProductIF p) {
		int N  = nOfProducts;
		return	   N * p.getP1() <= nOfP1
				&& N * p.getP2() <= nOfP2
				&& N * p.getP3() <= nOfP3
				&& N * p.getP4() <= nOfP4
				&& N * p.getP5() <= nOfP5;
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
					orderedP1 = true;
					break;
				case 2:
					nOfP2+= placedOrders.get(z).amount;
					purchasedParts += placedOrders.get(z).amount;
					orderedP2 = true;
					break;
				case 3:
					nOfP3+= placedOrders.get(z).amount;
					purchasedParts += placedOrders.get(z).amount;
					orderedP3 = true;
					break;
				case 4:
					nOfP4+= placedOrders.get(z).amount;
					purchasedParts += placedOrders.get(z).amount;
					orderedP4 = true;
					break;
				case 5:
					nOfP5+= placedOrders.get(z).amount;
					purchasedParts += placedOrders.get(z).amount;
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
		LOG("Parts used for Production: " + "Week " + iteration + " Part 1:" + nOfP1 + " Part 2: " + nOfP2 + " Part 3: " + nOfP3 + " Part 4: " + nOfP4 + " Part 5: " + nOfP5);
		
		nOfP1 -= w.getTotalP1();
		nOfP2 -= w.getTotalP2();
		nOfP3 -= w.getTotalP3();
		nOfP4 -= w.getTotalP4();
		nOfP5 -= w.getTotalP5();
		
		producedProducts = w.nOfA + w.nOfB+ w.nOfC + w.nOfD + w.nOfE;
	//	LOG("Products produced: " + "Week " + " ;ProA " + w.nOfA + " ;ProB " + w.nOfB + " ;ProC " + w.nOfC + " ;ProD " + w.nOfD + " ;ProE " + w.nOfE);
	}
	
	public void printStock(){
		System.out.println("Current Stock " + "Week " + iteration + " Part 1: " + nOfP1 + " Part 2: " + nOfP2 + " Part 3: " + nOfP3 + " Part 4: " + nOfP4 + " Part 5: " + nOfP5);
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
			produced++;
		}
		LOG("Produced product " + p.toString() + " :  "+produced + "/" + quantity);
		
		return quantity -produced;
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
	
	public void costManagement(int weekNumber){
		Costs costs = new Costs();
		int numberOfPartsOnStock = nOfP1 + nOfP2 + nOfP3 + nOfP4 + nOfP5;
		costs.calculateProfit(producedProducts, purchasedParts, numberOfPartsOnStock, 0, partsDeliveryCosts);
		costs.printData(weekNumber);
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
		//	System.out.println("Results for week: " + weekNumber + " Earnings: " + earnings + "; Costs: " + costs + "; Unsold Products " + unsoldProducts + "; Profit " + profit);
			System.out.println("Results for week: " + weekNumber + " Earnings: " + earnings + "; Costs: " + costs + "; Profit " + profit);
		}
	}
	
}
