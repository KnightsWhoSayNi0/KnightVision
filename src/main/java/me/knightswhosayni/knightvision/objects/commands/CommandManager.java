package me.knightswhosayni.knightvision.objects.commands;

import me.knightswhosayni.knightvision.objects.commands.impl.IntensityCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

	private List<Command> commandList;

	public CommandManager() {
		commandList = new ArrayList<>();
		commandList.add(new IntensityCommand());
	}

	public List<Command> getCommandList() {
		return commandList;
	}
}
