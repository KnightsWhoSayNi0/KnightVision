package me.knightswhosayni.knightvision.objects.commands.impl;

import me.knightswhosayni.knightvision.objects.commands.Command;
import me.knightswhosayni.knightvision.objects.fixture.FixtureManager;

public class RGBCommand extends Command {

	private FixtureManager fm;

	public RGBCommand(FixtureManager fixtureManager) {
		super("RGB", "Set the RGB color of a fixture.", null);
		this.fm = fixtureManager;
	}

	@Override
	public void onCommand(Object[] args) {
		if (args[0] instanceof String && args.length == 4 && args[1] instanceof String && args[2] instanceof String && args[3] instanceof String) {
			double r = 0, g = 0, b = 0;
			if (notNumeric(((String) args[1]))) {
				if (((String) args[1]).equalsIgnoreCase("fl")) r = 1;
				else if (((String) args[1]).equalsIgnoreCase("out")) r = 0;
				else return;
			} else {
				if (((String) args[1]).length() == 1) r = (Double.parseDouble(args[1] + "0")) / 100;
				else if (((String) args[1]).length() == 2) r = (Double.parseDouble((String) args[1])) / 100;
			}
			if (notNumeric(((String) args[2]))) {
				if (((String) args[2]).equalsIgnoreCase("fl")) g = 1;
				else if (((String) args[2]).equalsIgnoreCase("out")) g = 0;
				else return;
			} else {
				if (((String) args[2]).length() == 1) g = (Double.parseDouble(args[2] + "0")) / 100;
				else if (((String) args[2]).length() == 2) g = (Double.parseDouble((String) args[2])) / 100;
			}
			if (notNumeric(((String) args[3]))) {
				if (((String) args[3]).equalsIgnoreCase("fl")) b = 1;
				else if (((String) args[3]).equalsIgnoreCase("out")) b = 0;
				else return;
			} else {
				if (((String) args[3]).length() == 1) b = (Double.parseDouble(args[3] + "0")) / 100;
				else if (((String) args[3]).length() == 2) b = (Double.parseDouble((String) args[3])) / 100;
			}
			fm.getFixture(Integer.parseInt(String.valueOf(args[0]))).setRGB(r, g, b);
			fm.getFixture(Integer.parseInt(String.valueOf(args[0]))).updateDMX();
		}
	}

	private boolean notNumeric(String str) {
		return str == null || !str.matches("[-+]?\\d*\\.?\\d+");
	}

}
