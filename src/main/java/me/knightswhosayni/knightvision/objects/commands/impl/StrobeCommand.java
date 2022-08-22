package me.knightswhosayni.knightvision.objects.commands.impl;

import javafx.scene.input.KeyCode;
import me.knightswhosayni.knightvision.objects.commands.Command;
import me.knightswhosayni.knightvision.objects.fixture.FixtureManager;

public class StrobeCommand extends Command {

	private FixtureManager fm;

	public StrobeCommand(FixtureManager fixtureManager) {
		super("strobe", "Set the strobe of a fixture.", null);
		this.fm = fixtureManager;
	}

	@Override
	public void onCommand(Object[] args) {
		if (args[0] instanceof String && args.length == 2 && args[1] instanceof String) {
			double v = 0;

			if (!isNumeric(((String) args[1]))) {
				if (((String) args[1]).equalsIgnoreCase("fl")) v = 1;
				else if (((String) args[1]).equalsIgnoreCase("out")) v = 0;
				else return;
			} else {
				if (((String) args[1]).length() == 1) v = (Double.parseDouble(args[1] + "0")) / 100;
				else if (((String) args[1]).length() == 2) v = (Double.parseDouble((String) args[1])) / 100;
			}
			fm.getFixture(Integer.parseInt(String.valueOf(args[0]))).setStrobe(v);
			fm.getFixture(Integer.parseInt(String.valueOf(args[0]))).updateDMX();
		}
	}

	private boolean isNumeric(String str) {
		return str != null && str.matches("[-+]?\\d*\\.?\\d+");
	}

}
