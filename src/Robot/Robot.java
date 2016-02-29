package Robot;
import java.util.Random;
/**
 * @author julian
 * credit to: Jason Samuel Koch
 * @version 1.0
 * @created 13-Feb-2016 1:56:50 PM
 */
public class Robot {

	public Sensor m_Sensor;
	public SensedMap m_SensedMap;
	private double[] position; //2 elements: 1st is x position, 2nd is y position
	private double[][] waypoints;
	private double movementError, distBetweenWaypoints, distFromLastWaypoint, 
			error, xError, yError;
	private int fromWaypoint, toWaypoint;
	private int numMoves = 0;

	public Robot(){

	}

	public void finalize() throws Throwable {

	}

	public double[] findPosition(){
		return null;
	}

	public int move(){

		//find next position 1 unit away from last position
		//	divide both horz and vert component by distance between actual position and toWaypoint #UnitVector
		distBetweenWaypoints = Math.sqrt(Math.pow((waypoints[toWaypoint][0] - waypoints[fromWaypoint][0]),2) + 
				Math.pow((waypoints[toWaypoint][1] - waypoints[fromWaypoint][1]),2));

		double[] nextPosition = {(waypoints[toWaypoint][0] - position[0])/distBetweenWaypoints, 
				(waypoints[toWaypoint][1] - position[1])/distBetweenWaypoints};
		
		//change position var to new position
		position[0] = nextPosition[0];
		position[1] = nextPosition[1];
		numMoves++;//count number of updates since last change of waypoint
		
		//add error
		Random errorGen = new Random(); //create rng object
		
		while (Math.pow(xError,2) + Math.pow(yError,2) > 4) { //make sure x and y are in sensible range
			xError = errorGen.nextGaussian() * 2;
			yError = errorGen.nextGaussian() * 2;
		}
		
		position[0] += xError; //add error in x direction to position
		position[1] += yError; //add error in y direction to position

		//after robot has traveled ceil(distBetweenWaypoint)
		if (numMoves == Math.ceil(distBetweenWaypoints)){
			fromWaypoint = toWaypoint; //set current toWaypoint to fromWaypoint
			toWaypoint++;//	set next waypoint to toWaypoint
		}

		//call sensor.sense
		

		return position;
	}

}