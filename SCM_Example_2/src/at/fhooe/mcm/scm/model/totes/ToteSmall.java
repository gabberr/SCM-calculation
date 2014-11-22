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
	public double addPart(PartIF p) {
		return addPart(p);
	}
	@Override
	public double getFilledVolume() {
		return filledVolume;
	}

}
