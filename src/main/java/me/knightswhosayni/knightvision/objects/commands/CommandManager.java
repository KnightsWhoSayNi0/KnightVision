package me.knightswhosayni.knightvision.objects.commands;

import me.knightswhosayni.knightvision.objects.commands.impl.DimmerCommand;
import me.knightswhosayni.knightvision.objects.commands.impl.OutCommand;
import me.knightswhosayni.knightvision.objects.commands.impl.RGBCommand;
import me.knightswhosayni.knightvision.objects.commands.impl.StrobeCommand;
import me.knightswhosayni.knightvision.objects.fixture.FixtureManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager {

	private List<Command> commandList;
	public FixtureManager fm;

	public CommandManager(FixtureManager fixtureManager) {
		this.fm = fixtureManager;
		commandList = new ArrayList<>();
		commandList.add(new DimmerCommand(fm));
		commandList.add(new RGBCommand(fm));
		commandList.add(new StrobeCommand(fm));
		commandList.add(new OutCommand(fm));
	}

	public List<Command> getCommandList() {
		return commandList;
	}


	public boolean parseCommand(Object[] args) {
		List<Object> argList = new ArrayList<>(Arrays.stream(args).toList());
		try {
			for (Command c : commandList) {
				for (Object o : argList) {
					if (((String) o).equalsIgnoreCase(c.getName())) {
						System.out.println("hit! on " + c.getName());
						argList.remove(o);
						c.onCommand(argList.toArray());
						return true;
					}
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

}
