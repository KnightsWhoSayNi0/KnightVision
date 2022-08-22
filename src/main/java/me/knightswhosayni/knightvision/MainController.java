package me.knightswhosayni.knightvision;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import me.knightswhosayni.knightvision.artnet.ArtnetUtil;
import me.knightswhosayni.knightvision.objects.commands.CommandManager;
import me.knightswhosayni.knightvision.objects.fixture.FixtureManager;

public class MainController {

	public ListView<String> commandHistory;
	public TextField commandField;
	public TreeTableView propertiesTree;
	public ColorPicker colorPicker;
	public Slider slider;
	public Slider slider1;

	private final ArtnetUtil artnet = new ArtnetUtil();
	private final FixtureManager fm = new FixtureManager(artnet);
	private final CommandManager cm = new CommandManager(fm);

	public void commandFieldKeyPressed(KeyEvent keyEvent) {
		if (keyEvent.getCode().equals(KeyCode.ENTER)) {
			System.out.println("trying command: " + commandField.getText());
			if (cm.parseCommand(commandField.getText().split(" "))) { // call to parse command
				commandHistory.getItems().add(0, commandField.getText());
			} else {
				commandHistory.getItems().add(0, "\uD835\uDE0C\uD835\uDE19\uD835\uDE19\uD835\uDE16\uD835\uDE19"); // italicized "ERROR"
			}
			commandField.clear();
		}
	}

	public void sliderDrag() {
		fm.getFixture(0).setDimmer(slider.getValue());
		fm.getFixture(0).updateDMX();
	}

	public void colorChosen(ActionEvent actionEvent) {
		fm.getFixture(0).setRGB(colorPicker.getValue().getRed(), colorPicker.getValue().getGreen(), colorPicker.getValue().getBlue());
		fm.getFixture(0).updateDMX();
	}

	public void slider1Drag(MouseEvent mouseEvent) {
		fm.getFixture(0).setStrobe(slider1.getValue());
		fm.getFixture(0).updateDMX();
	}
}