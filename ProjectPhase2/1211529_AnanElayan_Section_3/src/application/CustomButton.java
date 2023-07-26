/*
 * Name :Anan Elayan 
 * ID :1211529 
 * sectione 3*/

package application;

import javafx.scene.control.Button;

public class CustomButton extends Button {

	public CustomButton(String name) {
		setText(name);
		setStyle("-fx-border-color:gray;-fx-border-radius:5;-fx-background-color:white");
	}

}
