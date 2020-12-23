package io.github.gmasterhd.skyblockhelper.utils;

import lombok.Getter;
import lombok.Setter;

public class GuiFeatureData {
	@Getter @Setter private int posX;
	@Getter @Setter private int posY;
	@Getter @Setter private int color;
	@Getter @Setter private float scale;
	
	public GuiFeatureData(int defaultPosX, int defaultPosY, int defaultColor, float defaultScale) {
		this.posX = defaultPosX;
		this.posY = defaultPosY;
		this.color = defaultColor;
		this.scale = defaultScale;
	}
	public GuiFeatureData(int defaultPosX, int defaultPosY, int defaultColor) {
		this(defaultPosX, defaultPosY, defaultColor, 1.0f);
	}
}
