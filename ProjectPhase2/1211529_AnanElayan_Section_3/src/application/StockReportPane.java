/*
 * Name: Anan Elayan 
 * ID :1211529 
 * sectione 3*/

package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StockReportPane extends VBox {

	// Data filed
	InventoryDriver mainObj;
	File file;
	Stage stage;
	static TextArea textArea;
	Label textTitel;
	GridPane gridPane;
	static CheckBox checkBox1;
	static CheckBox checkBox2;
	static TextField txtNameFile;
	static Button export;

	public static void resetStock() {
		txtNameFile.setVisible(false);// hide text filed name file
		export.setVisible(false);// hid button export button
		textArea.setVisible(false);
		textArea.setText("");
		checkBox2.setSelected(false);//hide checkBox 2 
		checkBox1.setSelected(false);//hide checkBox 1
	}

	public StockReportPane(InventoryDriver obj) {

		// storage obj in mainObj (of type Inventory Driver)
		this.mainObj = obj;
		gridPane = new GridPane();

		// title
		textTitel = new Label("The following options can be used to print a report");
		textTitel.setFont(Font.font(15));
		textTitel.setStyle("-fx-font-weight:bold");
		textTitel.setPadding(new Insets(1, 0, 0, 2));
		getChildren().add(textTitel);

		// add title in grid pane
		getChildren().add(gridPane);
		gridPane.setPadding(new Insets(5, 0, 0, 20));

		// check Box
		checkBox1 = new CheckBox("Export a copy to file");
		gridPane.add(checkBox1, 0, 0);
		checkBox2 = new CheckBox("TextArea");
		gridPane.add(checkBox2, 1, 0);

		// text field name file
		txtNameFile = new TextField();
		gridPane.add(txtNameFile, 0, 1);

		// export button
		export = new Button("Export");
		gridPane.add(export, 0, 2);

		// text Area
		textArea = new TextArea();
		setPadding(new Insets(0, 10, 10, 10));
		gridPane.add(textArea, 1, 3);
		gridPane.setVgap(5);

		txtNameFile.setVisible(false);// hide text filed name file
		export.setVisible(false);// hid button export button
		textArea.setVisible(false);
		textArea.setText("");
		checkBox2.setSelected(false);
		checkBox1.setSelected(false);

		// Action checkBox Export a copy to a file
		HandelrBoxExportCopyFile handelExportCheck = new HandelrBoxExportCopyFile();
		checkBox1.setOnAction(handelExportCheck);

		// action checkBox TextArea
		HandelrBoxTextArea handelTextArea = new HandelrBoxTextArea();
		checkBox2.setOnAction(handelTextArea);

		// Action button export
		HandelrExportButton handelExportButton = new HandelrExportButton();
		export.setOnAction(handelExportButton);
	}

	// inner class to handle export button
	class HandelrExportButton implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			try {
				//if the text filed  file name is empty 
				if (txtNameFile != null && txtNameFile.getText().trim().isEmpty()) {
					new Warning("Please set the file name");
					return;
				}
				if (txtNameFile.getText().endsWith(".txt")) { // It has text
					file = new File(txtNameFile.getText().trim());
					FileWriter write = new FileWriter(file);
					write.append(MainScene.store.stockReport());
					write.close();
					new Successfully();
				} else {
					new Warning(" \t error input \n  Please enter filename.txt");

				}
			} catch (IOException e) {
				e.getMessage();
			}
		}
	}

	// inner class to handle check box Exoprt_copy_file
	class HandelrBoxExportCopyFile implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			if (checkBox1.isSelected()) {
				txtNameFile.setVisible(true);
				export.setVisible(true);
			} else {
				txtNameFile.setVisible(false);
				export.setVisible(false);
			}

			if (checkBox2.isSelected()) {
				textArea.setVisible(true);
			} else
				textArea.setVisible(false);
		}
	}

	// inner class to handle check Box text_area
	class HandelrBoxTextArea implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			if (checkBox2.isSelected()) {
				textArea.setVisible(true);
				textArea.clear();
				textArea.setText(MainScene.store.stockReport());//add information stock report to text Area
			} else
				textArea.setVisible(false);
		}
	}

}
