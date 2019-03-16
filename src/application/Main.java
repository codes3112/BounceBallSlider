package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		BallPane ballPane=new BallPane();//create a ball pane
		Slider slSpeed=new Slider();// create a slider
		slSpeed.setMax(20);//set maximum value for slider
		ballPane.rateProperty().bind(slSpeed.valueProperty()); //bind rate with slider value
		
		BorderPane pane = new BorderPane();
		 pane.setCenter(ballPane);
	     pane.setBottom(slSpeed);
	     
 Scene scene = new Scene(pane, 250, 250);
		 
		 primaryStage.setTitle("BounceBallSlider"); // Set the stage title
		 primaryStage.setScene(scene); // Place the scene in the stage
		 primaryStage.show(); // Display the stage
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
