package application;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



public class eventOK implements EventHandler<ActionEvent >{
	
	
	@Override
	public void handle(ActionEvent args) {
		Pane pane = new Pane();
		Circle c = new Circle();
		c.setCenterX(100);
		c.setCenterY(100);
		c.setRadius(30);
		pane.getChildren().add(c);
		Scene scene = new Scene(pane,400,300);
		
		Stage s = new Stage();
		s.setScene(scene);
		s.show();
		
	}
}

class eventCancle implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent arg0) {
		System.out.println("Cancle button cliked");
		
	}
}
