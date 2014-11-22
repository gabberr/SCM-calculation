package at.fhooe.mcm.scm.model.part;

public class PartOne implements PartIF {

	@Override
	public double getVolume() {
		//dm3
		return 9.758;
	}

	@Override
	public int getPartId() {
		return 1;
	}

	@Override
	public boolean canFitIntoSmallTote() {
		return false;
	}

	@Override
	public int calculateWalkingTimeTo(PartIF part) {
		if(part instanceof PartOne){
			return 0;
		}else if(part instanceof PartTwo){
			return 10;
		}
		return -1;
	}

}
