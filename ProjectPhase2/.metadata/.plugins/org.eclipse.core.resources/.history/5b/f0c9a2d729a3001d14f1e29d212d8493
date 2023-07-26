/*
 * Name: Anan Elayan 
 * ID :1211529 
 * sectione 3*/

package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class InventoryDriver extends Application {

	// Data Field
	Scene mainScene;
	Stage PrimaryStage;
	CustomButton add = new CustomButton("Add");
	CustomButton modify = new CustomButton("Modify");
	CustomButton delete = new CustomButton("Delete");
	CustomButton stockReport = new CustomButton("Stock Report");

	@Override
	public void start(Stage MainStage) {

		// storage MainStage in PrimaryStage
		this.PrimaryStage = MainStage;

		// pane the main scene
		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-color:C0C0C0");

		// label title
		Label text = new Label("Inventory Management System : Comp 2311 Project, Phase 2");
		Font font = Font.font("Times new Roman", FontWeight.BOLD, FontPosture.ITALIC, 20);
		text.setStyle("-fx-text-fill:#5a4d60");
		text.setFont(font);
		text.setPadding(new Insets(0, 50, 0, 50));
		borderPane.setTop(text);

		// image
		Image image = new Image("inventoryManagement.jpg");
		ImageView imageView = new ImageView(image);
		imageView.setRotate(32);
		imageView.setFitWidth(300);
		imageView.setFitHeight(250);
		borderPane.setCenter(imageView);

		// button action
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(0, 0, 10, 0));
		hbox.getChildren().addAll(add, modify, delete, stockReport);
		borderPane.setBottom(hbox);

		// action add button
		AddHandelr handelSceneAdd = new AddHandelr(new Scene(new AddNewItemPane(this), 450, 350));
		add.setOnAction(handelSceneAdd);

		// action modify button
		ModifyHandelr handelSceneModify = new ModifyHandelr(new Scene(new UpdateItemPane(this), 550, 400));
		modify.setOnAction(handelSceneModify);

		// action scene delete button
		DeleteHandelr handelSceneDelete = new DeleteHandelr(new Scene(new DeletPane(this), 500, 350));
		delete.setOnAction(handelSceneDelete);

		// Action scene stockReport (open new Scene)
		StockHandelrScene handelSceneStock = new StockHandelrScene(new Scene(new StockReportPane(this), 700, 400));
		stockReport.setOnAction(handelSceneStock);

		// main Scene
		mainScene = new Scene(borderPane, 650, 450);
		MainStage.setScene(mainScene);
		MainStage.setTitle("Inventory Management System");
		MainStage.show();

	}

	// class handle add button
	class AddHandelr implements EventHandler<ActionEvent> {

		Scene scene;
		public AddHandelr(Scene scene) {
			this.scene = scene;
		}

		@Override
		public void handle(ActionEvent arg0) {
			Stage stage = new Stage();
			stage.setScene(this.scene);
			stage.setTitle("Add New Item");
			stage.show();
		}
	}

	
	
	// inner class to handle scene modify
	class ModifyHandelr implements EventHandler<ActionEvent> {

		Scene scene;

		// constructor
		public ModifyHandelr(Scene scene) {
			this.scene = scene;
		}

		@Override
		public void handle(ActionEvent arg0) {
			Stage stage = new Stage();
			stage.setScene(this.scene);
			stage.setTitle("Update New Item");
			stage.show();
		}
	}

	
	
	// inner class to handle scene delete button
	class DeleteHandelr implements EventHandler<ActionEvent> {
		Scene scene;

		public DeleteHandelr(Scene scene) {
			this.scene = scene;
		}

		@Override
		public void handle(ActionEvent arg0) {
			Stage stage = new Stage();
			stage.setScene(this.scene);
			stage.setTitle("Delete Item");
			stage.show();

		}
	}
	
	
	

	// inner class to handle scene StockReport
	class StockHandelrScene implements EventHandler<ActionEvent> {
		Scene scene;

		public StockHandelrScene(Scene scene) {
			this.scene = scene;
		}

		@Override
		public void handle(ActionEvent arg0) {
			Stage stage = new Stage();
			stage.setScene(this.scene);
			// hid text area
			stage.setTitle("Stock Report");
			stage.show();
			StockReportPane.resetStock();
		}
	}

	
	
	public static void main(String[] args) {

		try {
			File inventoryDatabase = new File("inventoryDatabase.txt");
			Scanner input = new Scanner(inventoryDatabase);// read from the file
			while (input.hasNextLine()) {// read all lines
				String lines = input.nextLine();// save line in lines variable
				String[] part1 = lines.split(",");//line cutting according (,)
				String[] part2 = part1[0].split(" ");//Cut off the first part of the line according (space)
				String[] part3 = part1[1].split(":");
				String type = null;
				int quantity = 0;
				double price = 0;
				String brand = null;

				price = Double.parseDouble(part3[1].replace("$", ""));// replace $ to space in price
				if (part2.length == 5) { // without brand
					type = part2[0];
					quantity = Integer.parseInt(part2[4]);
					MainScene.store.newItem(type, quantity, price);
				} else {// with brand
					brand = part2[0];
					type = part2[1];
					quantity = Integer.parseInt(part2[5]);
					MainScene.store.newItem(brand, type, quantity, price);
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}

		launch(args);
	}
}
