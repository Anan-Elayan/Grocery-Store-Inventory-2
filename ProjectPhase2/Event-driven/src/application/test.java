package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class test extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Button button = new Button("Click me!");
		Scene scene1 = new Scene(new StackPane(button), 300, 250);

		// Set the action for the button
		button.setOnAction(event -> {
		    // Create a second scene with a label
		    Label label = new Label("Hello, new scene!");
		    Scene scene2 = new Scene(new StackPane(label), 300, 250);

		    // Get the current stage and set the new scene
		    Stage stage = (Stage) button.getScene().getWindow();
		    stage.setScene(scene2);
		});

		// Create a new stage and set the first scene
		Stage stage = new Stage();
		stage.setScene(scene1);
		stage.show();		
	}

}
