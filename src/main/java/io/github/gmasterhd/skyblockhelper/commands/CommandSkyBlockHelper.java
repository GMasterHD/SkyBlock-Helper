package io.github.gmasterhd.skyblockhelper.commands;

import io.github.gmasterhd.skyblockhelper.SkyBlockHelper;
import io.github.gmasterhd.skyblockhelper.guis.GuiFeatures;
import io.github.gmasterhd.skyblockhelper.listeners.RenderListener;
import io.github.gmasterhd.skyblockhelper.main.Feature;
import io.github.gmasterhd.skyblockhelper.utils.EnumUtils;
import io.github.gmasterhd.skyblockhelper.utils.GuiFeatureData;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

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
		EntityPlayerSP player = (EntityPlayerSP) sender;
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("list")) {
				for(Feature f: Feature.values()) {
					logToChat(player,EnumChatFormatting.WHITE + f.getName() + ": " + EnumChatFormatting.BLUE + f.getId());
				}
			}
		} else if(args.length == 2) {
			if(args[0].equalsIgnoreCase("enable")) {
				try {
					int id = Integer.parseInt(args[1]);
					for(Feature f : Feature.values()) {
						if(id == f.getId()) {
							f.enable();
							logToChat(player, EnumChatFormatting.GREEN + "Successfully enabled feature with id " + EnumChatFormatting.BLUE + id);
						}
					}
				} catch(NumberFormatException e) {
					e.printStackTrace();
				}
			} else if(args[0].equalsIgnoreCase("disable")) {
				try {
					int id = Integer.parseInt(args[1]);
					for(Feature f : Feature.values()) {
						if(id == f.getId()) {
							f.disable();
							logToChat(player, EnumChatFormatting.GREEN + "Successfully disabled feature with id " + EnumChatFormatting.BLUE + id);
						}
					}
				} catch(NumberFormatException e) {
					e.printStackTrace();
				}
			}
		} else if(args.length == 3) {
			if(args[0].equalsIgnoreCase("scale")) {
				try {
					int id = Integer.parseInt(args[1]);
					float scale = Float.parseFloat(args[2]);
					for(Feature f: Feature.values()) {
						if(id == f.getId() && f.isGuiFeature()) {
							f.setGuiFeatureData(new GuiFeatureData(f.getGuiFeatureData().getPosX(), f.getGuiFeatureData().getPosY(), f.getGuiFeatureData().getColor(), scale));
						}
					}
				} catch(NumberFormatException e) {
					logToChat(player,EnumChatFormatting.RED + "You have to anter an id, posX and posY as an int");
					e.printStackTrace();
				}
			} else if(args[0].equalsIgnoreCase("color")) {
				try {
					int id = Integer.parseInt(args[1]);
					int color = 0;
					
					if(args[2].contains("0x")) {
						Integer.parseInt(args[2].replace("0x", ""), 16);
					} else {
						Integer.parseInt(args[2], 16);
					}
					
					for(Feature f: Feature.values()) {
						if(id == f.getId() && f.isGuiFeature()) {
							f.setGuiFeatureData(new GuiFeatureData(f.getGuiFeatureData().getPosX(), f.getGuiFeatureData().getPosY(), color, f.getGuiFeatureData().getScale()));
						}
					}
				} catch(NumberFormatException e) {
					logToChat(player,EnumChatFormatting.RED + "You have to anter an id and a color as hex code (e.q. 0x00FF00)");
					e.printStackTrace();
				}
			}
		} else if(args.length == 4) {
			if(args[0].equalsIgnoreCase("pos")) {
				try {
					int id = Integer.parseInt(args[1]);
					int posX = Integer.parseInt(args[2]);
					int posY = Integer.parseInt(args[3]);
					for(Feature f: Feature.values()) {
						if(id == f.getId() && f.isGuiFeature()) {
							f.setGuiFeatureData(new GuiFeatureData(posX, posY, f.getGuiFeatureData().getColor(), f.getGuiFeatureData().getColor()));
						}
					}
				} catch(NumberFormatException e) {
					logToChat(player,EnumChatFormatting.RED + "You have to anter an id, posX and posY as an int");
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Opening Gui...");
			RenderListener.guiToOpen = EnumUtils.Gui.FEATURES;
		}
		
		SkyBlockHelper.saves_file.save(SkyBlockHelper.saves);
	}
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true;
	}
	
	public static void logToChat(EntityPlayerSP player, String message) {
		player.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "[SkyBlocKHelper]: " + message));
	}
}
