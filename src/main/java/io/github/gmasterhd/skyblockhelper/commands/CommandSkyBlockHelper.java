package io.github.gmasterhd.skyblockhelper.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class CommandSkyBlockHelper extends CommandBase {
	@Override
	public String getCommandName() {
		return "sbh";
	}
	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/sbh";
	}
	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
	}
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true;
	}
}
