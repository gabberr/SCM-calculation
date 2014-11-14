package at.fhooe.mcm.scm.model;

public class WeekStock {
	public double getPart1() {
		return part1;
	}

	public void setPart1(double part1) {
		this.part1 = part1;
	}

	public double getPart2() {
		return part2;
	}

	public void setPart2(double part2) {
		this.part2 = part2;
	}

	public double getPart3() {
		return part3;
	}

	public void setPart3(double part3) {
		this.part3 = part3;
	}

	public double getPart4() {
		return part4;
	}

	public void setPart4(double part4) {
		this.part4 = part4;
	}

	public double getPart5() {
		return part5;
	}

	public void setPart5(double part5) {
		this.part5 = part5;
	}

	double part1;
	double part2;
	double part3;
	double part4;
	double part5;
	
	public WeekStock(double part1, double part2,double part3, double part4,double part5){
		this.part1 = part1;
		this.part2 = part2;
		this.part3 = part3;
		this.part4 = part4;
		this.part5 = part5;
	}
	public WeekStock(){
		this.part1 = 0;
		this.part2 = 0;
		this.part3 = 0;
		this.part4 = 0;
		this.part5 = 0;
	}
}
