package Robot;

import java.util.*;
import java.lang.*;
import java.io.*;
import Robot.Map;

@SuppressWarnings("unused")

public class Sensor {

	public Sensor(){
	}

	public void finalize() throws Throwable{
	}

	public void detectPoints(double rangeOfSensor, double robotX, double robotY ){

		int i = 0;

		int j = 0;

		int[][] refPointLoc = Map.refPoints;

		double rangeSensorX = rangeOfSensor + robotX;

		double rangeSensorY = rangeOfSensor + robotY;

		int pointDetectedX = -1;

		int pointDetectedY = -1;

		for(i = 0; i < refPointLoc.length; i++){

			for(j = 0; j < refPointLoc[i].length; j++){

				if(i == 0){
					if(refPointLoc[i][j] <= rangeSensorX ){
						pointDetectedX = refPointLoc[i][j];
					}
				}	

				if( i == 1){
					if(refPointLoc[i][j] <= rangeSensorY){
						pointDetectedY = refPointLoc[i][j];
					}
				}

				if(pointDetectedX != -1 && pointDetectedY != -1){

					File saveDetectedPoints = new File("DetectedPoints.txt");

					try{
						saveDetectedPoints.createNewFile();

						BufferedWriter bWSavePoints = new BufferedWriter(new FileWriter(saveDetectedPoints, true));

						bWSavePoints.write("" + pointDetectedX + " " + pointDetectedY + "\n");
						bWSavePoints.newLine();

						//System.out.println(pointDetectedX + " " + pointDetectedY);

						bWSavePoints.close();
					}
					catch (IOException iOEx1){

						//error message and scene and pane to pop up
					}
				}
			}
		}
	}
	
	public void pointsWithError(int sensorError){
		
		double xLoc = 0.0;
		
		double yLoc = 0.0;
		
		File getPoints = new File("DetectedPoints.txt");
		
		File savePointsError = new File("PointsWithError.txt");
		
		try{
			
			savePointsError.createNewFile();
			
			BufferedWriter bWPointsError = new BufferedWriter(new FileWriter(savePointsError, true));
			
			Scanner readDetectedPoints = new Scanner(getPoints);
			
			while(readDetectedPoints.hasNext()){
				
				xLoc = readDetectedPoints.nextInt()/(sensorError*100);
				
				yLoc = readDetectedPoints.nextInt()/(sensorError*100);
				
				bWPointsError.write("" + xLoc + " " + yLoc);
				bWPointsError.newLine();
			}
			bWPointsError.close();
			readDetectedPoints.close();
			
		}
		catch(IOException iOEx2){
			
			//error message and scene and pane to pop up
		}	
	}
	
	public void distanceBetweenPoints(){
		
		int point1;
		
		int point2;
		
		File getErrorPoints = new File("PointsWithError.txt");
		
		File difBetweenPoints = new File("DistanceBetweenPoints");
		
		try{
			
			difBetweenPoints.createNewFile();
			
			BufferedWriter bWDistance = new BufferedWriter(new FileWriter(difBetweenPoints, true));
			
			Scanner readErrorFile = new Scanner(getErrorPoints);
			
			bWDistance.close();

			readErrorFile.close();
		}
		catch(IOException iOEx3){
		
			//error message with scene and pane to pop up
		}
	}
}