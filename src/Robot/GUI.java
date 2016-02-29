package Robot;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


/**
 * @author julian
 * @version 1.0
 * @created 13-Feb-2016 1:56:50 PM
 */
public class GUI extends Application {

	public IO m_IO;
	private String moveString;

	//pane 
	private BorderPane MCLPane; 
	GridPane grid = new GridPane(); 

	//Menu stuff 
	private MenuBar menuBar; 

	//MenuBar 
	private Menu menuFile, menuHelp; 

	//Menus 
	private MenuItem miSave, miClose; 

	//save/close 
	private MenuItem miAbout;

	//Displays info about the program 
	private Text dataLog;

	public void finalize() throws Throwable {

	}

	public String getMoveString() {
		return moveString;
	}

	public void setMoveString(String moveString) {
		this.moveString = moveString;
	}

	public GUI(){ 
		//text stuff 
		dataLog.setFont(new Font(18));
		dataLog.relocate(100, 275); 
		dataLog.setText(String.format("Please click the 'Help' button for clarification\n"));
	}

	//invoke GUI
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		//make pane 
		MCLPane = new BorderPane();
		Pane buttonPane = new Pane();

		//create menu items
		miSave = new MenuItem("Save");
		miClose = new MenuItem("Close");

		//miStart = new MenuItem ("Start Simulation");
		miAbout = new MenuItem("About");    

		// Create Menus
		menuFile = new Menu("File");
		menuHelp = new Menu("Help");      

		// Create MenuBar
		menuBar = new MenuBar();    

		// Add menu items to respective menus
		menuFile.getItems().addAll(miSave, miClose);
		menuHelp.getItems().addAll(miAbout);

		// Add menus to menuBar
		menuBar.getMenus().addAll(menuFile, menuHelp);

		//Event Handlers
		miAbout.setOnAction(e -> showAbout());
		miClose.setOnAction(e -> Platform.exit());

		/* PUT EVERYTHING TOGETHER */
		Scene scene = new Scene(MCLPane, 950, 850);
		StackPane root= new StackPane();

		// Add the menu bar and shapes to the border pane
		MCLPane.setTop(menuBar);
		MCLPane.setCenter(grid);

		// Configure and display the stage
		stage.setScene(scene);
		stage.setTitle("Monte Carlo Localization Simulator");

		//won't allow user to resize grid
		stage.setResizable(false);
		stage.show();

		//GridPane things
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(5);
		grid.setHgap(5);

		//Defining the text field
		final TextField range = new TextField();
		range.setPromptText("Enter a range");
		range.setPrefColumnCount(20);
		range.getText();
		GridPane.setConstraints(range, 0, 0);
		grid.getChildren().add(range);

		//Defining  text field
		final TextField refPoints = new TextField();
		refPoints.setPromptText("Enter a number of reference points");
		GridPane.setConstraints(refPoints, 0, 1);
		grid.getChildren().add(refPoints);

		//Defining text field
		final TextField error = new TextField();
		error.setPrefColumnCount(25);
		error.setPromptText("Enter sensor error percentage");
		GridPane.setConstraints(error, 0, 2);
		grid.getChildren().add(error);

		//Defining text field
		final TextField waypoints = new TextField();
		waypoints.setPrefColumnCount(25);
		waypoints.setPromptText("Enter amount of waypoints");
		GridPane.setConstraints(waypoints, 0, 3);
		grid.getChildren().add(waypoints);

		//Defining text field
		final TextField move = new TextField();
		move.setPrefColumnCount(25);
		move.setPromptText("Enter movement error percentage");
		GridPane.setConstraints(move, 0, 4);
		grid.getChildren().add(move);

		//Defining the start sim button
		Button start = new Button("Start Simulation");
		start.setStyle("-fx-font: 20 Comic Sans; -fx-base: #6b6a6b;"); //change button color
		GridPane.setConstraints(start, 1, 0);
		grid.getChildren().add(start);

		//Defining the Clear button
		Button clear = new Button("Clear");
		clear.setStyle("-fx-font: 20 Comic Sans; -fx-base:#ebebeb;"); //change button color
		GridPane.setConstraints(clear, 1, 1);
		grid.getChildren().add(clear);

		//Setting an action for the Clear button
		clear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				range.clear();
				refPoints.clear();
				error.clear();
				waypoints.clear();
				move.clear();
			}
		});
	}
	/** Shows information about the program in it's own window */
	private void showAbout(){
		//text i want
		final String aboutText ="This program was designed by Miralda Rodney,"
				+ " Jadeira Lu, Julian Pryde, and Stephen Kristin in collaboration with"
				+ " Dr.Garfield.";

		// Create the text label
		Label aboutLabel = new Label();
		aboutLabel.setWrapText(true);
		aboutLabel.setTextAlignment(TextAlignment.CENTER);
		aboutLabel.setFont(Font.font("Comic Sans MS", 20));
		aboutLabel.setText(aboutText);

		// Add the label to a StackPane
		StackPane pane = new StackPane();
		pane.getChildren().add(aboutLabel);

		// Create and display said the aforementioned pane in a new stage   
		Scene scene = new Scene(pane, 550, 200);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("About this program");
		stage.setResizable(false);
		stage.show();
	}
}