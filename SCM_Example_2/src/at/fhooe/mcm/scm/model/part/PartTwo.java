package at.fhooe.mcm.scm.model.part;

public class PartTwo implements PartIF {

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return 1.344;
	}

	@Override
	public int getPartId() {
		return 2;
	}

	@Override
	public boolean canFitIntoSmallTote() {
		return true;
	}

	@Override
	public int calculateWalkingTimeTo(PartIF part) {
		if(part instanceof PartOne){
			return 10;
		}else if(part instanceof PartTwo){
			return 0;
		}else if(part instanceof PartThree){
			return 20;
		}else if(part instanceof PartFour){
			return 25;
		}
		return -1;
	}

}
