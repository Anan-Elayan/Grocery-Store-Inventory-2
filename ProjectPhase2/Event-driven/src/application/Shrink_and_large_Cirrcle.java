package application;

import org.w3c.dom.events.MouseEvent;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Shrink_and_large_Cirrcle extends Application {

	private CircelPane pane;
	private BorderPane base;

	@Override
	public void start(Stage primaryStage) {

		pane = new CircelPane();
		base = new BorderPane();

		HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(0, 0, 10, 0));
		hbox.setAlignment(Pos.CENTER);
		Button Enlarge = new Button("Enlarge");
		Button Shrink = new Button("Shrink");

		EnlargHandelr handelenlarg = new EnlargHandelr();
		Enlarge.setOnAction(handelenlarg);
		ShrinkHandelr handelshrink = new ShrinkHandelr();
		Shrink.setOnAction(handelshrink);
		hbox.getChildren().addAll(Enlarge, Shrink);
		base.setCenter(pane);
		base.setBottom(hbox);

		Scene scene = new Scene(base, 500, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Demo event Driven");
		primaryStage.show();
		pane.requestFocus();
	}

	class CircelPane extends StackPane {
		Circle circle = new Circle();

		public CircelPane() {
			circle.setRadius(20);
			circle.setStroke(Color.BLACK);
			circle.setFill(Color.RED);
			getChildren().add(circle);

		}

		public void enlarge() {
			if (circle.getRadius() <= 50) {
				circle.setRadius(circle.getRadius() + 2);

			}
		}

		public void shrink() {
			if (circle.getRadius() >= 20) {
				circle.setRadius(circle.getRadius() - 2);
			}
		}
	}

	class EnlargHandelr implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {

			pane.enlarge();
		}

	}

	class ShrinkHandelr implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {


			pane.shrink();

		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
