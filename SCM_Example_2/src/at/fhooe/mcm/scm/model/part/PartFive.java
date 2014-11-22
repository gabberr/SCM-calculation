package at.fhooe.mcm.scm.model.part;

public class PartFive implements PartIF {

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return 2.535;
	}

	@Override
	public int getPartId() {
		return 5;
	}

	@Override
	public boolean canFitIntoSmallTote() {
		return true;
	}

	@Override
	public int calculateWalkingTimeTo(PartIF part) {
		if(part instanceof PartFive){
			return 0;
		}else if(part instanceof PartFour){
			return 30;
		}
		return -1;
	}

}
