/*
 * Name: Anan Elayan 
 * ID :1211529 
 * sectione 3*/

package application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Successfully extends VBox {

	//Data Filed
	private CustomButton done;
	private Stage primaryStage;

	
	public Successfully() {

		StackPane pane = new StackPane();
		Circle circle = new Circle();
		circle.setRadius(30);
		circle.setFill(Color.GREEN);

		setAlignment(Pos.CENTER);
		Label label = new Label("Success");
		Font fontText = new Font(20);
		Text text = new Text("!");
		text.setFont(fontText);

		text.setFill(Color.WHITE);
		Font font = Font.font(20);
		label.setFont(font);
		pane.getChildren().addAll(circle, text);

		done = new CustomButton("Done");
		done.setMinWidth(30);
		done.setMinHeight(30);
		
		//Action button successfully
		handelButtonSucf handelButton = new handelButtonSucf();
		done.setOnAction(handelButton);

		getChildren().addAll(pane, label, done);
		setSpacing(10);

		primaryStage = new Stage();
		primaryStage.setScene( new Scene(this, 400, 150));
		primaryStage.setTitle("Successfully");
		primaryStage.show();

	}

	
	//inner Class to handle button successfully
	class handelButtonSucf implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			primaryStage.close();
		}

	}
}
