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

		int squirrel;

		//Instantiate GUI
		GUI gui = new GUI();
		
		//Instantiate IO
		IO io = new IO();

		//Instantiate robot
		Robot robot = new Robot();
		Sensor sensor = new Sensor();

		//Instantiate map
		Map map = new Map();

		for (squirrel = 0; squirrel < robot.getNumWaypoints(); squirrel++){
			robot.move();
		}

	}

}