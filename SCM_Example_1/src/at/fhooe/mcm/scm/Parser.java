package at.fhooe.mcm.scm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
	 
	  public void parseObjects() {
	 
		ClassLoader classLoader = getClass().getClassLoader();
	//	File file2 = new File(this.getClass().getResource("SCM_Programming_Example_1.csv"));
	//	File file = new File(classLoader.getResource("SCM_Programming_Example_1.csv").getFile());
//		String file = p.getFileName().toString();
		String csvFile = "C://Users//Philipp//Desktop//Hagenberg//SupplyChain//SCM-calculation//SCM_Example_1//resources//SCM_Programming_Example_1.csv";
//		String csvFileGaber = "C://Users//Philipp//Desktop//Hagenberg//SupplyChain//SCM-calculation//SCM_Example_1//resources//SCM_Programming_Example_1.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
	 
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
			//  country = line.split(cvsSplitBy);
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
	 
}
