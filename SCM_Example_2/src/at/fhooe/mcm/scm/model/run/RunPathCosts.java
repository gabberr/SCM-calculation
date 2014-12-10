package at.fhooe.mcm.scm.model.run;

import java.util.ArrayList;

public class RunPathCosts {
	
	private static final  int[][] pathCost = {
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
	
	static int getTotalPathCosts( ArrayList<Integer> path) {
		int total = 0;
		for(int i =0; i< path.size() +1 ; i++)
		{
			int current = path.get(i);
			int next = path.get(i+1);
			total+=getPathCosts(current, next);
		}
		return total;
	}
	
	
	
}
