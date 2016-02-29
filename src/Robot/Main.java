package Robot;


/**
 * @author julian
 * @version 1.0
 * @created 13-Feb-2016 1:56:50 PM
 */
public class Main {

	public Map m_Map;
	public GUI m_GUI;
	public Robot m_Robot;

	public Main(){
	}

	public void finalize() throws Throwable {

	}

	public void main(){

		//Instantiate GUI
		GUI gui = new GUI();

	}

	public void simulate(int numRefPoints, int[] waypoint1, int[] waypoint2, double range,
			double sensorError, double movementError, GUI gui, Map map){
		//Instantiate IO
		IO io = new IO();

		//Instantiate robot
		Robot robot = new Robot(gui, map, waypoint1, waypoint2);

		//Instantiate map
		Map map = new Map();
		
		int squirrel;
		for (squirrel = 0; squirrel < robot.getNumWaypoints(); squirrel++){
			robot.move(gui, map);
		}
	}

}