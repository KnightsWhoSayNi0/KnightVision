package me.knightswhosayni.knightvision.objects.commands.impl;

import javafx.scene.input.KeyCode;
import me.knightswhosayni.knightvision.objects.commands.Command;
import me.knightswhosayni.knightvision.objects.fixture.FixtureManager;

public class DimmerCommand extends Command {

	private FixtureManager fm;

	public DimmerCommand(FixtureManager fixtureManager) {
		super("@", "Set intensity of a fixture.", KeyCode.EQUALS);
		this.fm = fixtureManager;
	}

	@Override
	public void onCommand(Object[] args) {
		System.out.println("onCommand");
		if (args[0] instanceof String && args.length == 2 && args[1] instanceof String) {
			fm.getFixture(Integer.parseInt(String.valueOf(args[0]))).setDimmer(Double.parseDouble((String) args[1]));
			fm.getFixture(Integer.parseInt(String.valueOf(args[0]))).updateDMX();
			System.out.println("did the thing");
		}
	}

}
