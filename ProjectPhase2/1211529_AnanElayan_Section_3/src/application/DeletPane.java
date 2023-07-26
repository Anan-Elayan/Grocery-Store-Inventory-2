/*
 * Name :Anan Elayan 
 * ID :1211529 
 * sectione 3*/

package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeletPane extends MainScene {

	// date field
	ComboBox<String> comboBox = new ComboBox<>();
	Stage primaryStage;
	InventoryDriver mainObj;
	TextField txtBrandName;

	public DeletPane(InventoryDriver object) {

		// storage object in mainObj (of type Inventory Driver)
		this.mainObj = object;

		// action button
		this.btnAction.setText("Delete");

		// Brand Name
		txtBrandName = new TextField();
		txtBrandName.setText("Brand Name");
		txtBrandName.setStyle("-fx-text-inner-color:green");
		txtFieldType.setText("Item Type");
		txtFieldType.setStyle("-fx-text-inner-color:green");

		// comboBox
		comboBox.setEditable(true);
		comboBox.setVisible(true);
		comboBox.getItems().addAll("Brand", "Not Brand");
		comboBox.setMaxWidth(150);
		add(comboBox, 1, 0);

		// action comboBox
		HandelComboBox handelComboBox = new HandelComboBox();
		comboBox.setOnAction(handelComboBox);

		// action delete button
		HandelarDeleteButton handelDeleteButton = new HandelarDeleteButton();
		btnAction.setOnAction(handelDeleteButton);

	}

	// inner class to handle comboBox
	class HandelComboBox implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {

			try {
				if (!(comboBox.getValue().equals("Brand")) && !(comboBox.getValue().equals("Not Brand"))) {
					new Warning("Please Select Brand or Not");// window alert
					return;
				}

				if (comboBox.getValue().equals("Brand")) {
					add(txtBrandName, 2, 1);

				} else {
					getChildren().remove(txtBrandName);
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}

	}

	// inner class to handle action delete button
	class HandelarDeleteButton implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {

			//if not selected any thing in combo box
			if (comboBox.getValue() == null) {
				new Warning("Please Select Brand or Not");
				return;
			}

			if (comboBox.getValue().equals("Brand")) {

				if (txtFieldType.getText().trim().isEmpty()) { // There is no text in the type field
					new Warning("Please set the type");// window warning alert
					return;
				}

				//there is no text in brand name field
				if (txtBrandName.getText().trim().isEmpty()) {
					new Warning("Please set the Brand Name");
					return;
				}

				store.delete(txtFieldType.getText().trim(), txtBrandName.getText().trim());// delete item with Brand
				if (store.text == null) {
					new Successfully();// window successfully alert
				}

				else
					new Warning("Cannot Find Item");

			} else {// not brand
				if (txtFieldType.getText().trim().isEmpty()) {
					new Warning("Please set the type");// window warning alert
					return;
				}
				store.delete(txtFieldType.getText().trim());// delete item with not Brand
				if (store.text == null) {
					new Successfully();// window successfully alert

				}

				else
					new Warning("Cannot Find Item");
			}
		}

	}

}
