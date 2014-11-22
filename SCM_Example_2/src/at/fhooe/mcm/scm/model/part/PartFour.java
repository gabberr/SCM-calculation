package at.fhooe.mcm.scm.model.part;

public class PartFour implements PartIF {

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return 0.64;
	}

	@Override
	public int getPartId() {
		return 4;
	}

	@Override
	public boolean canFitIntoSmallTote() {
		return true;
	}

	@Override
	public int calculateWalkingTimeTo(PartIF part) {
		if(part instanceof PartFour){
			return 0;
		}else if(part instanceof PartTwo){
			return 25;
		}else if(part instanceof PartFive){
			return 30;
		}else if(part instanceof PartThree){
			return 10;
		}
		return -1;
	}

}
