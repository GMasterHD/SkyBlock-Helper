package io.github.gmasterhd.skyblockhelper.listeners;

import io.github.gmasterhd.skyblockhelper.features.SecretsFoundDisplay;
import io.github.gmasterhd.skyblockhelper.guis.GuiFeatures;
import io.github.gmasterhd.skyblockhelper.main.Feature;
import io.github.gmasterhd.skyblockhelper.utils.EnumUtils;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class RenderListener {
	@Getter private static RenderListener instance = new RenderListener();
	
	public static EnumUtils.Gui guiToOpen;
	
	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent.Post e) {
		if(e.type == RenderGameOverlayEvent.ElementType.EXPERIENCE || e.type == RenderGameOverlayEvent.ElementType.JUMPBAR) {
			if(Feature.FEATURE_SECRETS_FOUND_DISPLAY.isEnabled()) {
				SecretsFoundDisplay.render();
			}
		}
	}
	
	@SubscribeEvent
	public void onRenderGuis(TickEvent.RenderTickEvent e) {
		if(guiToOpen == EnumUtils.Gui.FEATURES) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiFeatures());
			guiToOpen = null;
		}
	}
}
