package Robot;


/**
 * @author julian
 * @version 1.0
 * @created 13-Feb-2016 1:56:50 PM
 */
public class Robot {

	public Sensor m_Sensor;
	public SensedMap m_SensedMap;
	private double[] position;
	private double[][] waypoints;
	private double movementError;

	public Robot(){

	}

	public void finalize() throws Throwable {

	}
	
	public double[] findPosition(){
		return null;
	}

	public int move(){
		
		//find next position 1 unit away from last position
	
		//calculate new position with error
		//	if dist to next waypoint <= 1 unit, position at next waypoint.
		//	if dist to next waypoint > 1 unit, position = 1 unit in direction of next waypoint
		//	increment currentWaypoint by 1
	
		//
		
		//change position var to new position
		
		//increment currentWaypoint by 1
	
		//call 
		
		return 0;
	}

}