package Robot;
import javafx.stage.*;

/**
 * @author julian
 * @version 1.0
 * @created 13-Feb-2016 1:56:50 PM
 */
public class Main {

	public Map m_Map;
	public static GUI gui;
	public Robot m_Robot;

	public Main(){
		
	}

	public void finalize() throws Throwable {

	}

	public static void main(String[] args){
		
		gui.showGUI();

	}

	public static void simulate(int numRefPoints, int[] waypoint1, int[] waypoint2, double range,
			double sensorError, double movementError){

		//Instantiate robot
		Robot robot = new Robot();

		//Instantiate map
		Map map = new Map();
		
		int squirrel;
		for (squirrel = 0; squirrel < robot.getNumWaypoints(); squirrel++){
			robot.move(gui, map, waypoint1, waypoint2);
		}
		
		
	}

}