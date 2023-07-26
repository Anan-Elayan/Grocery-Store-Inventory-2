package application;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Anonymous_Inner_Class extends Application {

	HBox hbox;
	Button buttonNew;
	Button buttonOpen;
	Button buttonSave;
	Button buttonPrint;

	@Override
	public void start(Stage PrimaryStage) {
		hbox = new HBox(10);

		buttonNew = new Button("New");
		buttonOpen = new Button("Open");
		buttonOpen.setOnAction(e-> {
			System.out.println("HI");
			
		});
		
		Pane pane = new Pane();
		Text text = new Text (20,20,"Programing is fun");
		text.setOnMouseDragged(e ->{
			text.setX(e.getX());
			text.setY(e.getY());

		});
		pane.getChildren().add(text);
		
		
		
		
		
		buttonSave = new Button("Save");
		buttonSave.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Save cliked");
			}

		});
		
		
		buttonPrint = new Button("Print");
		buttonPrint.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Print cliked");
			}
		});
		
		
		hbox.getChildren().addAll(buttonNew, buttonOpen, buttonSave, buttonPrint);
		hbox.setAlignment(Pos.CENTER);

		Scene scene = new Scene(pane, 400, 300);
		PrimaryStage.setScene(scene);
		PrimaryStage.setTitle("Annonymous class");
		PrimaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
