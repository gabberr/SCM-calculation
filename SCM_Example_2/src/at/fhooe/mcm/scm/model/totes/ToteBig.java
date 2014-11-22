package at.fhooe.mcm.scm.model.totes;

import at.fhooe.mcm.scm.model.part.PartIF;

public class ToteBig implements ToteIF{
	
	public static double totalVolume=57.6;
	private double filledVolume;
	
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
