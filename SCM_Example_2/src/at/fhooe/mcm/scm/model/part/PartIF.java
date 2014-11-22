package at.fhooe.mcm.scm.model.part;

public interface PartIF {
	
	public double getVolume();
	public int getPartId();
	public boolean canFitIntoSmallTote();
	public int calculateWalkingTimeTo(PartIF part);
}
