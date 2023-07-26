/*
 * Name: Anan Elayan 
 * ID :1211529 
 * sectione 3*/

package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddNewItemPane extends MainScene {

	// date field
	ToggleGroup group;
	RadioButton radioButtonYes;
	RadioButton radioButtonNo;
	Label brandName;
	TextField txtBrandName;
	Stage stage;
	InventoryDriver mainObj;

	// No argument constructor
	public AddNewItemPane() {

	}

	public AddNewItemPane(InventoryDriver object) {

		// storage object in objUpdate (of type Inventory Driver)
		this.mainObj = object;
		this.btnAction.setText("Save");

		// radio button
		group = new ToggleGroup();
		radioButtonYes = new RadioButton("Yse");
		radioButtonNo = new RadioButton("No");
		radioButtonYes.setToggleGroup(group);
		radioButtonNo.setToggleGroup(group);

		RadioHandeler radioHandeler = new RadioHandeler();
		radioButtonNo.setOnAction(radioHandeler);// action (no) button in radio box
		radioButtonYes.setOnAction(radioHandeler);// action (yes) button in radio box

		HBox RadioButtonHbox = new HBox(10);

		// add radio button in HBox
		RadioButtonHbox.getChildren().addAll(radioButtonYes, radioButtonNo);
		add(RadioButtonHbox, 1, 0);

		// label brand name
		brandName = new Label("Brand Name");
		brandName.setStyle(this.lblStyle);
		add(brandName, 0, 4);

		// label text filed
		txtBrandName = new TextField();
		txtBrandName.setStyle(this.txtStyle);
		add(txtBrandName, 1, 4);

		radioButtonNo.setSelected(true);// in default selected the no combo box
		brandName.setVisible(false);
		txtBrandName.setVisible(false);

		// action save button
		BtnAddAction handelSave = new BtnAddAction();
		this.btnAction.setOnAction(handelSave);
	}

	// inner class to Handle Radio Button
	class RadioHandeler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {

			if (radioButtonNo.isSelected()) {
				brandName.setVisible(false);// hid label
				txtBrandName.setVisible(false);// hid text field
				txtBrandName.setText("");
				txtBrandName.clear();
			}

			else {
				brandName.setVisible(true);// show label
				txtBrandName.setVisible(true);// show text field
			}

		}

	}

	// inner class to Handle Save Button
	class BtnAddAction implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {

			if (radioButtonNo.isSelected()) {// not Brand
				if (txtFieldType.getText().trim().isEmpty()) {//if the text filed type empty
					new Warning("Please set the type");
					return;
				}

				if (txtFieldQuantity.getText().trim().isEmpty()) {//if the text filed quantity empty
					new Warning("Please set the qunatity");
					return;
				}
				try {
					Integer.parseInt(txtFieldQuantity.getText().trim());
				} catch (NumberFormatException e) {
					new Warning("InValid Input for quantity");//if Entry error in quantity
					return;
				}

				if (txtFieldPrice.getText().trim().isEmpty()) {
					new Warning("Please set the price");//if no text price 
					return;
				}

				try {
					Double.parseDouble(txtFieldPrice.getText().trim());
				} catch (NumberFormatException e) {
					new Warning("InValid Input for price");//if Entry error in price
					return;
				}

				store.newItem(txtFieldType.getText().trim(), Integer.parseInt(txtFieldQuantity.getText().trim()),
						Double.parseDouble(txtFieldPrice.getText()));// add new item with not brand

				if (store.text == null) {
					new Successfully();

				} else
					txtMessage.setText(store.text.getText().trim());

			} else {// brand

				if (txtFieldType.getText().trim().isEmpty()) {
					new Warning("Please set the type");
					return;
				}

				if (txtFieldQuantity.getText().trim().isEmpty()) {
					new Warning("Please set the qunatity");
					return;
				}
				try {
					Integer.parseInt(txtFieldQuantity.getText().trim());
				} catch (NumberFormatException e) {
					new Warning("InValid Input for quantity");//if Entry error in quantity
					return;
				}

				if (txtFieldPrice.getText().trim().isEmpty()) {
					new Warning("Please set the price");//if no text price 
					return;
				}

				try {
					Double.parseDouble(txtFieldPrice.getText().trim());
				} catch (NumberFormatException e) {
					new Warning("InValid Input for price");
					return;
				}

				if (txtBrandName.getText().isEmpty()) {
					new Warning("Please set the Brand Name");
					return;
				}
				try {
					txtBrandName.getText();
				} catch (NumberFormatException e) {
					new Warning("InValid Input for Brand Name");
					return;
				}

				store.newItem(txtBrandName.getText().trim(), txtFieldType.getText().trim(),
						Integer.parseInt(txtFieldQuantity.getText().trim()),
						Double.parseDouble(txtFieldPrice.getText().trim()));// add
				// new
				// item
				// wit
				// brand

				if (store.text == null) {
					new Successfully();

				} else
					txtMessage.setText(store.text.getText().trim());
			}
		}

	}

}
