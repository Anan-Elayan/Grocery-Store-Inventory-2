/*
 * Name :Anan Elayan 
 * ID :1211529 
 * sectione 3*/

package application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Warning extends VBox {
	
	//Data Filed
	private CustomButton ok;
	private Stage primaryStage;

	
	public Warning(String msg) {

		setAlignment(Pos.CENTER);
		Label label = new Label(msg);
		Font font = Font.font(20);
		label.setFont(font);
		ok = new CustomButton("ok");
		ok.setStyle("-fx-font-size:15");
		ok.setMinWidth(30);
		ok.setMinHeight(30);
		getChildren().addAll(label, ok);

		handelButtonWarning handelButton = new handelButtonWarning();
		ok.setOnAction(handelButton);

		primaryStage = new Stage();
		primaryStage.setScene(new Scene(this, 400, 150));
		primaryStage.setTitle("warning");
		primaryStage.show();

	}

	class handelButtonWarning implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {

			primaryStage.close();
		}

	}
}
