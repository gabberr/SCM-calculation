package at.fhooe.mcm.scm.model.totes;

import at.fhooe.mcm.scm.model.part.PartIF;


public interface ToteIF {
	double getTotalVolume();
	boolean isAddable(PartIF p);
	void addPart(PartIF p);
	double getFilledVolume();
	int getWalkingTime();
}
