package at.fhooe.mcm.scm.model.run;

import java.util.ArrayList;

import at.fhooe.mcm.scm.model.part.PartFive;
import at.fhooe.mcm.scm.model.part.PartFour;
import at.fhooe.mcm.scm.model.part.PartOne;
import at.fhooe.mcm.scm.model.part.PartThree;
import at.fhooe.mcm.scm.model.part.PartTwo;
import at.fhooe.mcm.scm.model.totes.ToteBig;

public class RunLL implements RunIF {

	ToteBig t1;
	ToteBig t2;
	public RunLL(ToteBig _t1, ToteBig _t2) {
		t1=_t1;
		t2=_t2;
	}
	@Override
	public double getTotalTime() {

		return 0;
	}

	@Override
	public int getLowestPartID() {
		int id1 = t1.getLowestPartID();
		int id2 = t2.getLowestPartID();
		if(id1 > id2)
			return id2;
		return id1;
	}

	@Override
	public int getHighestPartID() {
		int id1 = t1.getHighestPartID();
		int id2 = t2.getHighestPartID();
		if(id1 > id2)
			return id1;
		return id2;
	}

	@Override
	public ArrayList<Integer> getPartPath() {
		// TODO Auto-generated method stub
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		if(t1.hasPart(new PartOne()))
			path.add(1);
		if(t1.hasPart(new PartTwo()))
			path.add(2);
		if(t1.hasPart(new PartThree()))
			path.add(3);
		if(t1.hasPart(new PartFour()))
			path.add(4);
		if(t1.hasPart(new PartFive()))
			path.add(5);
		

		if(t2.hasPart(new PartOne()) && !t1.hasPart(new PartOne()))
			path.add(1);
		if(t2.hasPart(new PartTwo()) && !t1.hasPart(new PartTwo()))
			path.add(2);
		if(t2.hasPart(new PartThree()) && !t1.hasPart(new PartThree()))
			path.add(3);
		if(t2.hasPart(new PartFour()) && !t1.hasPart(new PartFour()))
			path.add(4);
		if(t2.hasPart(new PartFive()) && !t1.hasPart(new PartFive()))
			path.add(5);
		return path;
	}

}
