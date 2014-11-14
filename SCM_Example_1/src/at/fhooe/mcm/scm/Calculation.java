package at.fhooe.mcm.scm;

import java.util.ArrayList;

import at.fhooe.mcm.scm.model.Week;

public class Calculation {

	public Parser p = new Parser();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parser p = new Parser();
		
		ArrayList<Week> weeks = p.parseObjects();
		//p.parseWeek("input line");
	}

}
