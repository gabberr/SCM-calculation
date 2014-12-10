package at.fhooe.mcm.scm.model.totes;

import java.util.ArrayList;

import at.fhooe.mcm.scm.model.part.PartIF;

public class ToteSmall implements ToteIF{
	
	public static double totalVolume=12.8;
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

	@Override
	public int getWalkingTime() {
		int time=0;
		for (int i = 0; i < addedParts.size()-1; i++) {
			time += addedParts.get(i).calculateWalkingTimeTo(addedParts.get(i+1));
			
		}
		return time;
	}

	@Override
	public void printToteParts() {
		String output="Small: ";
		for (int i = 0; i < addedParts.size(); i++) {
			output += ""+addedParts.get(i).getPartId();
		}
		System.out.println("Parts in tote: " + output);
		
	}

	@Override
	public int getLowestPartID() {
		int id = 5;
		for (int i = 0; i < addedParts.size(); i++) {
			if(addedParts.get(i).getPartId()<id)
				id = addedParts.get(i).getPartId();
		}
		return id;
	}

	@Override
	public int getHighestPartID() {
		int id = 1;
		for (int i = 0; i < addedParts.size(); i++) {
			if(addedParts.get(i).getPartId()>id)
				id = addedParts.get(i).getPartId();
		}
		return id;
	}

	@Override
	public boolean hasPart(PartIF p) {
		for (int i = 0; i < addedParts.size(); i++) {
			if(addedParts.get(i).getPartId() == p.getPartId())
				return true;
		}
		return false;
	}

}
