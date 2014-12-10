package at.fhooe.mcm.scm.model.run;

public class RunPathCosts {
	
	static int[][] pathCost = {
		{0, 10, 30, 35, 65},
		{10, 0, 20, 25, 55},
		{30, 20, 0, 10, 40},
		{35, 25, 10, 0, 30},
		{65, 55, 40, 30, 0}
	};
	
	static int getPathCosts(int i, int j) {
		i--;
		j--;
		return pathCost[i][j];
		
	}
	
	
	
	
}
