package at.fhooe.mcm.scm.model.run;

import java.util.ArrayList;
import java.util.Collections;

import at.fhooe.mcm.scm.model.part.PartFive;
import at.fhooe.mcm.scm.model.part.PartFour;
import at.fhooe.mcm.scm.model.part.PartOne;
import at.fhooe.mcm.scm.model.part.PartThree;
import at.fhooe.mcm.scm.model.part.PartTwo;
import at.fhooe.mcm.scm.model.totes.ToteBig;
import at.fhooe.mcm.scm.model.totes.ToteSmall;

public class RunLS implements RunIF {

	ToteBig t1;
	ArrayList<ToteSmall> tSmallList;
	static final int basicCosts = 30 + 60 + 120 + 15;

	public RunLS(ToteBig _t1, ArrayList<ToteSmall> tSmallList) {
		t1 = _t1;
		this.tSmallList = tSmallList;
	}
	
	public RunLS( ToteBig t){
		this.t1 = t;
		this.tSmallList = new ArrayList<ToteSmall>();
	}

	public void addSmallTote(ToteSmall t){
		this.tSmallList.add(t);
	}
	
	public boolean isAddable(){
		if(tSmallList.size() < 5){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public double getTotalTime() {
		//calculate the basic costs including small totes
		int basicCostsSmallTote = 0;
		for(int i = 0; i< tSmallList.size(); i++){
			basicCostsSmallTote += 5;
		}
		int totalBasicCosts = basicCosts + basicCostsSmallTote;
		
		int pathCost = RunPathCosts.getTotalPathCosts(getPartPath());
		return totalBasicCosts + pathCost;
	}

	@Override
	public int getLowestPartID() {
		int id1 = t1.getLowestPartID();
		int id2 = tSmallList.get(0).getLowestPartID();
		for(int i = 0; i< tSmallList.size();i++){
			if(tSmallList.get(i).getLowestPartID() < id2){
				id2 = tSmallList.get(i).getLowestPartID();
			}
		}
	
		if (id1 > id2)
			return id2;
		return id1;
	}

	@Override
	public int getHighestPartID() {
		int id1 = t1.getHighestPartID();
		int id2 = tSmallList.get(0).getHighestPartID();
		for(int i = 0; i< tSmallList.size();i++){
			if(tSmallList.get(i).getHighestPartID() > id2){
				id2 = tSmallList.get(i).getLowestPartID();
			}
		}

		if (id1 > id2)
			return id1;
		return id2;
	}

	@Override
	public ArrayList<Integer> getPartPath() {
		ArrayList<Integer> path = new ArrayList<Integer>();

		if (t1.hasPart(new PartOne()))
			path.add(1);
		if (t1.hasPart(new PartTwo()))
			path.add(2);
		if (t1.hasPart(new PartThree()))
			path.add(3);
		if (t1.hasPart(new PartFour()))
			path.add(4);
		if (t1.hasPart(new PartFive()))
			path.add(5);

		ToteSmall tSmall;
		for(int i = 0; i< tSmallList.size(); i++){
			tSmall = tSmallList.get(i);
			if (tSmall.hasPart(new PartOne()) && !path.contains(1))
				path.add(1);
			if (tSmall.hasPart(new PartTwo()) && !path.contains(2))
				path.add(2);
			if (tSmall.hasPart(new PartThree()) && !path.contains(3))
				path.add(3);
			if (tSmall.hasPart(new PartFour()) && !path.contains(4))
				path.add(4);
			if (tSmall.hasPart(new PartFive()) && !path.contains(5))
				path.add(5);
		}
		Collections.sort(path);
		return path;
	}

}
