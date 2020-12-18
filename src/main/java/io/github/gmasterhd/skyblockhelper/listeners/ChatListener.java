package io.github.gmasterhd.skyblockhelper.listeners;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatListener {
	@SubscribeEvent
	public void onChatReceive(ClientChatReceivedEvent e) {
		if(e.type == 0) {
			// Chat Message
		} else if(e.type == 2) {
			// Action Bar Message
		}
	}
}
