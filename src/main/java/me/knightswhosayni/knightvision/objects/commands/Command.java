package me.knightswhosayni.knightvision.objects.commands;

import javafx.scene.input.KeyCode;

public abstract class Command {

	private String name;
	private String description;
	private KeyCode keyCode;

	public Command(String name, String description, KeyCode keyCode) {
		this.name = name;
		this.description = description;
		this.keyCode = keyCode;
	}

	public abstract void onCommand(String[] args);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public KeyCode getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(KeyCode keyCode) {
		this.keyCode = keyCode;
	}
}
