package at.fhooe.mcm.scm.model.run;

import java.util.ArrayList;

public interface RunIF {
	
	double getTotalTime();
//	boolean hasPart(int partID)
	int getLowestPartID();
	int getHighestPartID();
	ArrayList<Integer> getPartPath();

}
