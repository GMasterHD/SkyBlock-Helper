package io.github.gmasterhd.skyblockhelper.listeners;

import io.github.gmasterhd.skyblockhelper.features.SecretsFoundDisplay;
import io.github.gmasterhd.skyblockhelper.main.Feature;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderListener {
	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent.Post e) {
		if(e.type == RenderGameOverlayEvent.ElementType.EXPERIENCE || e.type == RenderGameOverlayEvent.ElementType.JUMPBAR) {
			if(Feature.FEATURE_SECRETS_FOUND_DISPLAY.isEnabled()) {
				SecretsFoundDisplay.render();
			}
		}
	}
}
