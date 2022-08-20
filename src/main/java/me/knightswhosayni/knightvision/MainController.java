package me.knightswhosayni.knightvision;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import me.knightswhosayni.knightvision.objects.Fixture;
import me.knightswhosayni.knightvision.objects.commands.CommandManager;

public class MainController {

	public ListView<String> commandHistory;
	public TextField commandField;
	public TreeTableView propertiesTree;

	private CommandManager cm = new CommandManager();

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
		if (isNumeric(split[0]) && split.length>1) { // todo use Fixture fixture = fixtureManager.getFixture(id: Integer.parseInt(split[0])); and check for return if exists
			Fixture fixture = new Fixture();
			if (split[1].equals("@") && split.length == 3 && isNumeric(split[2])) {

				return true;
			} else return false;
		} else return false;
	}


	private boolean isNumeric(String str) {
		return str != null && str.matches("[-+]?\\d*\\.?\\d+");
	}

}