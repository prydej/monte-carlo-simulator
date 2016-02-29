package Robot;
import java.util.Random;

/**
 * @author Stephen Kristin
 * @version 1.0
 * @last modified 2/29/2016
 */


public class Map{
	
	// seed random number generation
	Random gen = new Random();

	public int[][] refPoints;

	// exception handling 
	public void finalize() throws Throwable {}

	// create reference points as objects and add to array of objects 
	public void createPoints(int NumberRefPoints){
		// variables for loop iteration
		int i, j;
		
		for (i=0; i < NumberRefPoints; i++ ){//NumberRefPoints
			for (j=0; j<2; j++){
				refPoints[i][j]= gen.nextInt(100);
			}			
		}
	}
	

}