package at.fhooe.mcm.scm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import at.fhooe.mcm.scm.model.Week;

public class Parser {

	public ArrayList<Week> parseObjects() {

		ClassLoader classLoader = getClass().getClassLoader();
		// File file2 = new
		// File(this.getClass().getResource("SCM_Programming_Example_1.csv"));
		// File file = new
		// File(classLoader.getResource("SCM_Programming_Example_1.csv").getFile());
		// String file = p.getFileName().toString();
		String csvFile ="/Users/gaber/Developer/SCM-calculation/SCM_Example_1/resources/SCM_Programming_Example_1_complete.csv";
		// String csvFileGaber =
		// "C://Users//Philipp//Desktop//Hagenberg//SupplyChain//SCM-calculation//SCM_Example_1//resources//SCM_Programming_Example_1.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		ArrayList<Week> weeks = new ArrayList<Week>();
		try {

			br = new BufferedReader(new FileReader(csvFile));
			
			Week weekObject;
			String[] lineInput;
			while ((line = br.readLine()) != null) {
				// use comma as separator
				lineInput = line.split(cvsSplitBy);
				weekObject = new Week(lineInput[0], Integer.parseInt(lineInput[1]),Integer.parseInt(lineInput[2]),Integer.parseInt(lineInput[3]),Integer.parseInt(lineInput[4]),Integer.parseInt(lineInput[5]));
				weeks.add(weekObject);
				//weekObject.printWeekOrderByParts();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
		return weeks;
	}
}
