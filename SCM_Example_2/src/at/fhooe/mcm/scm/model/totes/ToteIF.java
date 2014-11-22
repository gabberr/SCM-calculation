package at.fhooe.mcm.scm.model.totes;

import at.fhooe.mcm.scm.model.part.PartIF;


public interface ToteIF {
	double getTotalVolume();
	boolean isAddable(PartIF p);
	double addPart(PartIF p);
	double getFilledVolume();
}
