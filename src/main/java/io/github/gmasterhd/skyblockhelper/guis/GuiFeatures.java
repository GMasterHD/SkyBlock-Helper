package io.github.gmasterhd.skyblockhelper.guis;

import io.github.gmasterhd.skyblockhelper.guis.buttons.ButtonFeature;
import io.github.gmasterhd.skyblockhelper.guis.buttons.ButtonFeatureSettings;
import io.github.gmasterhd.skyblockhelper.main.Feature;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import scala.collection.parallel.ParIterableLike;

import java.io.IOException;

public class GuiFeatures extends GuiScreen {
	public static final ResourceLocation feature_background = new ResourceLocation("skyblockhelper", "gui/feature_background.png");
	public static final ResourceLocation title = new ResourceLocation("skyblockhelper", "gui/title.png");
	
	public GuiFeatures() {
		super();
	}
	
	/*int titleWidth = 790 / 5;
	int titleHeight = 105 / 5;*/
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		GlStateManager.enableBlend();
		ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
		
		int titleWidth = 790 / 5;
		int titleHeight = 105 / 5;
		
		drawRect(28, 18, res.getScaledWidth() - 28, res.getScaledHeight() - 28, 0xAA000000);
		
		GlStateManager.color(1, 1, 1, 1);
		
		Minecraft.getMinecraft().renderEngine.bindTexture(title);
		drawModalRectWithCustomSizedTexture((int)((res.getScaledWidth() - titleWidth) * 0.5f), 20, 0, 0, titleWidth, titleHeight, titleWidth, titleHeight);

		GlStateManager.disableBlend();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	@Override
	public void initGui() {
		super.initGui();
		int startPosX = 30;
		int startPosY = 42;
		int lineHeight = 18;
		int line = 0;
		ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
		
		for(Feature f: Feature.values()) {
			int posY = startPosY + line * 20;
			buttonList.add(new ButtonFeature(f.getId(), startPosX, posY, res.getScaledWidth() - startPosX * 2 - lineHeight - 12, lineHeight, f));
			buttonList.add(new ButtonFeatureSettings(Feature.values().length + f.getId(), res.getScaledWidth() - startPosX - lineHeight - 9, startPosY, lineHeight, lineHeight, f));
			
			++line;
		}
	}
}
