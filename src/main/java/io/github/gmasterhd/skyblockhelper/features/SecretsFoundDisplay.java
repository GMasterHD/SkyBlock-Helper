package io.github.gmasterhd.skyblockhelper.features;

import io.github.gmasterhd.skyblockhelper.main.Feature;

import net.minecraft.client.Minecraft;

public class SecretsFoundDisplay {
	public static int last_current;
	public static int last_count;
	
	public static void render() {
		String text = last_current + "/" + last_count + " Scecrets";
		Minecraft.getMinecraft().fontRendererObj.drawString(text, Feature.FEATURE_SECRETS_FOUND_DISPLAY.getGuiFeatureData().getPosX(), Feature.FEATURE_SECRETS_FOUND_DISPLAY.getGuiFeatureData().getPosY(), Feature.FEATURE_SECRETS_FOUND_DISPLAY.getGuiFeatureData().getColor());
	}
	public static void update(int current, int count) {
		last_current = current;
		last_count = count;
	}
}
