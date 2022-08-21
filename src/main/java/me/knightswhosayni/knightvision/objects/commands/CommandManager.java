package me.knightswhosayni.knightvision.objects.commands;

import me.knightswhosayni.knightvision.objects.commands.impl.DimmerCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

	private List<Command> commandList;

	public CommandManager() {
		commandList = new ArrayList<>();
		commandList.add(new DimmerCommand());
	}

	public List<Command> getCommandList() {
		return commandList;
	}
}
