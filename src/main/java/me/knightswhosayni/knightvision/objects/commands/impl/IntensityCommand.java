package me.knightswhosayni.knightvision.objects.commands.impl;

import javafx.scene.input.KeyCode;
import me.knightswhosayni.knightvision.objects.Fixture;
import me.knightswhosayni.knightvision.objects.commands.Command;

public class IntensityCommand extends Command {

	public IntensityCommand() {
		super("@", "Set intensity of a fixture.", KeyCode.EQUALS);
	}

	@Override
	public void onCommand(String[] args, Fixture fixture) {

	}
}
