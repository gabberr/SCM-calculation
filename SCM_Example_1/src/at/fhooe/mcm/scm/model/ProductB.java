package at.fhooe.mcm.scm.model;

public class ProductB implements ProductIF {

	@Override
	public int getP1() {
		
		return 2;
	}

	@Override
	public int getP2() {
		
		return 0;
	}

	@Override
	public int getP3() {
		
		return 1;
	}

	@Override
	public int getP4() {
		
		return 0;
	}

	@Override
	public int getP5() {
		
		return 1;
	}
	@Override
	public String toString() {
		return "ProductB";
	}
}
