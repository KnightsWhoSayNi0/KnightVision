package me.knightswhosayni.knightvision.objects.commands.impl;

import javafx.scene.input.KeyCode;
import me.knightswhosayni.knightvision.objects.commands.Command;
import me.knightswhosayni.knightvision.objects.fixture.FixtureManager;

public class OutCommand extends Command {

	private FixtureManager fm;

	public OutCommand(FixtureManager fixtureManager) {
		super("out", "Shortcut for 0.", null);
		this.fm = fixtureManager;
	}

	@Override
	public void onCommand(Object[] args) {
		if (args[0] instanceof String && args.length == 1) {
			fm.getFixture(Integer.parseInt(String.valueOf(args[0]))).setDimmer(0);
			fm.getFixture(Integer.parseInt(String.valueOf(args[0]))).updateDMX();
		}
	}

}
