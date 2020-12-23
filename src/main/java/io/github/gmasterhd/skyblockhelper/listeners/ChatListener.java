package io.github.gmasterhd.skyblockhelper.listeners;

import io.github.gmasterhd.skyblockhelper.features.SecretsFoundDisplay;
import io.github.gmasterhd.skyblockhelper.main.Feature;
import io.github.gmasterhd.skyblockhelper.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatListener {
	@SubscribeEvent
	public void onChatReceive(ClientChatReceivedEvent e) {
		String u_text = e.message.getUnformattedText();
		String f_text = e.message.getFormattedText();
		String m_text = e.message.getUnformattedText().replace(",", "").toLowerCase();
		
		if(e.type == 0) {
			// Chat Message
			if(!m_text.contains(":")) {
				// ---> Check if a dungeon is starting soon <--- //
				if(m_text.contains("dungeon starts in 1 second.")) {
					Utils.saveFloor(Minecraft.getMinecraft().theWorld.getScoreboard());
					Utils.isInDungeon = true;
				}
				// ---> Check if a dungeon has finished <--- //
				if(m_text.contains("the catacombs - floor") && m_text.contains("stats")) {
					Utils.isInDungeon = false;
				}
			}
		} else if(e.type == 2) {
			// Action Bar Message
			
			// If the Secrets found display is enabled, the player is in a dungeon and the message contains a slash
			// Secrets Message: 0/5 Secrets
			if(Feature.FEATURE_SECRETS_FOUND_DISPLAY.isEnabled() && Utils.isInDungeon && m_text.contains("/") && m_text.contains("secrets")) {
				int current = Integer.parseInt(m_text.substring(m_text.lastIndexOf("/") - 1, m_text.lastIndexOf("/")));
				int count = Integer.parseInt(m_text.substring(m_text.lastIndexOf("/") + 1, m_text.lastIndexOf("/") + 2));
				
				SecretsFoundDisplay.update(current, count);
				
				e.message = new ChatComponentText(e.message.getFormattedText().replace(current + "/" + count + " Secrets", ""));
			}
		}
	}
}
