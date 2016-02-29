package Robot;
import java.util.Random;
import java.util.Arrays;
/**
 * @author julian
 * credit to: Jason Samuel Koch
 * @version 1.0
 * @created 13-Feb-2016 13:56
 * @modified 29-Feb-2016 16:25
 */
public class Robot {

	public Sensor sensor;
	public SensedMap m_SensedMap;
	private double[] calcPosition, positionWError; //2 elements: 1st is x position, 2nd is y position
	private double[][] waypoints, position;
	private double movementError, distBetweenWaypoints, distFromLastWaypoint, 
			error, xError, yError;
	private int fromWaypoint, toWaypoint, numWaypoints, chipmunk;
	private int numMoves = 0;
	private String outputString;

	public Robot(){
		sensor = new Sensor();
	}
	
	public int getNumWaypoints(){
		return this.numWaypoints;
	}

	public void finalize() throws Throwable {

	}

	public double[] findPosition(){
		return null;
	}

	public double[][] move(GUI gui, Map map, int[] start, int[] end){
		
		waypoints[0][0] = (double) start[0];
		waypoints[0][1] = (double) start[1];
		waypoints[1][0] = (double) end[0];
		waypoints[1][1] = (double) end[1];

		//find next position 1 unit away from last position
		//	divide horz and vert component by distance between actual position and toWaypoint #UnitVector
		distBetweenWaypoints = Math.sqrt(Math.pow((waypoints[toWaypoint][0] - 
				waypoints[fromWaypoint][0]),2) + 
				Math.pow((waypoints[toWaypoint][1] - waypoints[fromWaypoint][1]),2));

		//loop through all stops between waypoints
		for (chipmunk = 0; chipmunk < distBetweenWaypoints; chipmunk++){
			
			double[] nextPosition = {(waypoints[toWaypoint][0] - position[chipmunk][0])/
					distBetweenWaypoints, 
					(waypoints[toWaypoint][1] - position[chipmunk][1])/distBetweenWaypoints};

			//change position var to new position
			position[chipmunk][0] = nextPosition[0];
			position[chipmunk][1] = nextPosition[1];
			numMoves++;//count number of updates since last change of waypoint

			//add error
			Random errorGen = new Random(); //create rng object

			while (Math.pow(xError,2) + Math.pow(yError,2) > 4) { //make sure x, y are in sensible range
				xError = errorGen.nextGaussian() * 2;
				yError = errorGen.nextGaussian() * 2;
			}

			positionWError[0] += xError; //add error in x direction to position
			positionWError[1] += yError; //add error in y direction to position

			//after robot has traveled ceil(distBetweenWaypoint)
			if (numMoves == Math.ceil(distBetweenWaypoints)){
				fromWaypoint = toWaypoint; //set current toWaypoint to fromWaypoint
				toWaypoint++;//	set next waypoint to toWaypoint
			}

			//call sensor.sense()
			sensor.sense();

			//call this.calculate()
			position[chipmunk] = this.calculate(positionWError, Map.refPoints);
			
			//send info to GUI
			outputString = "Ideal Positions: " + Arrays.toString(position[chipmunk]) + 
					"\nPositions with Error " + Arrays.toString(positionWError);
			gui.setMoveString(outputString);		
			
		}
		return position;
	}

	public double[] calculate(int position, int points){

		calcPosition[0] = 0;
		calcPosition[1] = 1;

		return calcPosition;
	}

}