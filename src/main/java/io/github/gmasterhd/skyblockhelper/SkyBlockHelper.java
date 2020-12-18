package io.github.gmasterhd.skyblockhelper;

import io.github.gmasterhd.skyblockhelper.commands.CommandSkyBlockHelper;
import io.github.gmasterhd.skyblockhelper.json.Saves;
import io.github.gmasterhd.skyblockhelper.listeners.ChatListener;
import io.github.gmasterhd.skyblockhelper.utils.PersistentFile;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=SkyBlockHelper.MODID, version = SkyBlockHelper.VERSION, acceptedMinecraftVersions = "1.8.9", clientSideOnly = true)
public class SkyBlockHelper {
	public static final String MODID = "skyblockhelper";
	public static final String VERSION = "0.0.1";
	
	public static PersistentFile<Saves> saves_file;
	public static Saves saves;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		saves = new Saves();
		saves_file = new PersistentFile<Saves>(e.getModConfigurationDirectory() + "skyblockhelper/saves.json", saves);
		
		saves = saves_file.load(Saves.class);
	}
	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(new ChatListener());
	}
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		ClientCommandHandler.instance.registerCommand(new CommandSkyBlockHelper());
	}
}
