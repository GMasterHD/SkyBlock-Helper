package io.github.gmasterhd.skyblockhelper.guis.buttons;

import io.github.gmasterhd.skyblockhelper.main.Feature;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;

public class ButtonFeature extends GuiButton {
	Feature feature = null;
	
	public ButtonFeature(int buttonId, int x, int y, int widthIn, int heightIn, Feature f) {
		super(buttonId, x, y, widthIn, heightIn, f.getName());
		this.feature = f;
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		if(feature.isEnabled()) {
			drawRect(xPosition, yPosition, xPosition + width, yPosition + height, 0xEEB200FF);
			drawRect(xPosition + 1, yPosition + 1, xPosition + width - 1, yPosition + height - 1, 0xFF000000);
		} else {
			drawRect(xPosition, yPosition, xPosition + width, yPosition + height, 0xEE000000);
		}
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(feature.getName(), xPosition + 5, yPosition + 5, 0xFFFFFF);
	}
	
	@Override
	public void playPressSound(SoundHandler soundHandlerIn) {
		super.playPressSound(soundHandlerIn);
		
		if(feature.isEnabled()) {
			feature.disable();
		} else {
			feature.enable();
		}
	}
}
