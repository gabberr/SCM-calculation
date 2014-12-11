package at.fhooe.mcm.scm.model.run;

import java.util.ArrayList;
import java.util.Collections;

import at.fhooe.mcm.scm.model.part.PartFive;
import at.fhooe.mcm.scm.model.part.PartFour;
import at.fhooe.mcm.scm.model.part.PartOne;
import at.fhooe.mcm.scm.model.part.PartThree;
import at.fhooe.mcm.scm.model.part.PartTwo;
import at.fhooe.mcm.scm.model.totes.ToteSmall;

public class RunSS implements RunIF{
	ArrayList<ToteSmall> tSmallList;
	static final int basicCosts = 30 + 60 + 120;

	public RunSS(){
		this.tSmallList = new ArrayList<ToteSmall>();
	}
	
	public RunSS(ArrayList<ToteSmall> tSmallList) {
		this.tSmallList = tSmallList;
	}

	public void addSmallTote(ToteSmall t){
		this.tSmallList.add(t);
	}
	
	public boolean isAddable(){
		if(tSmallList.size() < 10){
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
		int id2 = tSmallList.get(0).getLowestPartID();
		for(int i = 0; i< tSmallList.size();i++){
			if(tSmallList.get(i).getLowestPartID() < id2){
				id2 = tSmallList.get(i).getLowestPartID();
			}
		}
		return id2;
	}

	@Override
	public int getHighestPartID() {
		int id2 = tSmallList.get(0).getHighestPartID();
		for(int i = 0; i< tSmallList.size();i++){
			if(tSmallList.get(i).getHighestPartID() > id2){
				id2 = tSmallList.get(i).getLowestPartID();
			}
		}
		return id2;
	}

	@Override
	public ArrayList<Integer> getPartPath() {
		ArrayList<Integer> path = new ArrayList<Integer>();

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
