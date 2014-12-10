package at.fhooe.mcm.scm.model.totes;

import java.util.ArrayList;

import at.fhooe.mcm.scm.model.part.PartIF;

public class ToteBig implements ToteIF{
	
	public static double totalVolume=57.6;
	private double filledVolume;
	
	ArrayList<PartIF> addedParts = new ArrayList<PartIF>();
	
	@Override
	public double getTotalVolume() {
		return totalVolume;
	}
	@Override
	public boolean isAddable(PartIF p) {
		return filledVolume + p.getVolume() <= totalVolume;
	}
	@Override
	public void addPart(PartIF p) {
		filledVolume += p.getVolume();
		addedParts.add(p);
	}
	@Override
	public double getFilledVolume() {
		return filledVolume;
	}
	public int getWalkingTime() {
		int time=0;
		for (int i = 0; i < addedParts.size()-1; i++) {
			time += addedParts.get(i).calculateWalkingTimeTo(addedParts.get(i+1));
			
		}
		return time;
	}

}
