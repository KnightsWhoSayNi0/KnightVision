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

	private CommandManager cm = new CommandManager();
	private ArtnetUtil artnet = new ArtnetUtil();
	private FixtureManager fixtureManager = new FixtureManager(artnet);

	public void commandFieldKeyPressed(KeyEvent keyEvent) {
		if (keyEvent.getCode().equals(KeyCode.ENTER)) {
			if (parseCommand(commandField.getText())) {
				commandHistory.getItems().add(0, commandField.getText());
				commandField.clear();
			} else {
				commandHistory.getItems().add(0, "\uD835\uDE0C\uD835\uDE19\uD835\uDE19\uD835\uDE16\uD835\uDE19"); // italicized "ERROR"
				commandField.clear();
			}
		}
	}

	private boolean parseCommand(String text) { // test works!
		String[] split = text.split(" ");
		if (split[0].equals("test")) {
			artnet.dmxData[0] = (byte)(colorPicker.getValue().getRed()*255);
			artnet.dmxData[1] = (byte)(colorPicker.getValue().getGreen()*255);
			artnet.dmxData[2] = (byte)(colorPicker.getValue().getBlue()*255);
			artnet.broadcast(0);
			return true;
		}
		if (isNumeric(split[0]) && split.length>1) { // todo use Fixture fixture = fixtureManager.getFixture(id: Integer.parseInt(split[0])); and check for return if exists
			if (split[1].equals("@") && split.length == 3 && isNumeric(split[2])) {

				return true;
			} else return false;
		} else return false;
	}


	private boolean isNumeric(String str) {
		return str != null && str.matches("[-+]?\\d*\\.?\\d+");
	}

	public void sliderDrag() {
		fixtureManager.getFixture(0).setDimmer(slider.getValue());
		fixtureManager.getFixture(0).updateDMX();
	}

	public void colorChosen(ActionEvent actionEvent) {
		fixtureManager.getFixture(0).setRGB(colorPicker.getValue().getRed(), colorPicker.getValue().getGreen(), colorPicker.getValue().getBlue());
		fixtureManager.getFixture(0).updateDMX();
	}

	public void slider1Drag(MouseEvent mouseEvent) {
		fixtureManager.getFixture(0).setStrobe(slider1.getValue());
		fixtureManager.getFixture(0).updateDMX();
	}
}