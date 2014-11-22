package at.fhooe.mcm.scm.model.part;

public class PartThree implements PartIF {

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return 7.938;
	}

	@Override
	public int getPartId() {
		return 3;
	}

	@Override
	public boolean canFitIntoSmallTote() {
		return false;
	}

	@Override
	public int calculateWalkingTimeTo(PartIF part) {
		if(part instanceof PartThree){
			return 0;
		}else if(part instanceof PartTwo){
			return 20;
		}else if(part instanceof PartFour){
			return 10;
		}
		return -1;
	}

}
