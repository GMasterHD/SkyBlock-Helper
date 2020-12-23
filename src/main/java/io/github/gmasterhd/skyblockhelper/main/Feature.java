package io.github.gmasterhd.skyblockhelper.main;

import io.github.gmasterhd.skyblockhelper.SkyBlockHelper;
import io.github.gmasterhd.skyblockhelper.utils.FileUtils;
import io.github.gmasterhd.skyblockhelper.utils.GuiFeatureData;
import lombok.Getter;
import lombok.Setter;

public enum Feature {
	FEATURE_SECRETS_FOUND_DISPLAY(0, "Secrets Found Display", "Shows you how many secrets are found in the current room", true, new GuiFeatureData(10, 10, 0x0033FF));
	;
	
	@Getter private int id;
	@Getter private String name;
	@Getter private String description;
	@Getter private boolean enabled;
	@Getter private GuiFeatureData guiFeatureData;
	
	/**
	 * @param id: ID of the feature in config file
	 * @param name: Feature name
	 * @param description: Feature description
	 * @param defaultEnabled: If the feature is enabled by default
	 * @param guiFeatureData: If the feature is a gui feature, instead set to null
	 */
	Feature(int id, String name, String description, boolean defaultEnabled, GuiFeatureData guiFeatureData) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.enabled = defaultEnabled;
		this.guiFeatureData = guiFeatureData;
		
		if(FileUtils.hasValue(SkyBlockHelper.saves.Features, id + "") && FileUtils.hasValue(SkyBlockHelper.saves.Features.getAsJsonObject(id + ""), "enabled")) {
			enabled = getConfig_boolean("enabled");
		} else {
			setConfig("enabled", enabled);
		}
		
		if(guiFeatureData != null) {
			if(FileUtils.hasValue(SkyBlockHelper.saves.Features, id + "") && FileUtils.hasValue(SkyBlockHelper.saves.Features.getAsJsonObject(id + ""), "color")) {
				guiFeatureData.setColor(getConfig_int("color"));
			} else {
				setConfig("color", guiFeatureData.getColor());
			}
		}
	}
	
	public boolean isGuiFeature() {
		return guiFeatureData != null;
	}
	
	public void enable() {
		this.enabled = true;
		setConfig("enabled", true);
	}
	public void disable() {
		this.enabled = false;
		setConfig("enabled", false);
	}
	
	public void setConfig(String key, int value) {
		FileUtils.setConfigValue(this, key, value);
	}
	public void setConfig(String key, float value) {
		FileUtils.setConfigValue(this, key, value);
	}
	public void setConfig(String key, boolean value) {
		FileUtils.setConfigValue(this, key, value);
	}
	public void setConfig(String key, String value) {
		FileUtils.setConfigValue(this, key, value);
	}
	
	public int getConfig_int(String key) {
		return FileUtils.readConfigValue_int(this, key);
	}
	public float getConfig_float(String key) {
		return FileUtils.readConfigValue_float(this, key);
	}
	public boolean getConfig_boolean(String key) {
		return FileUtils.readConfigValue_boolean(this, key);
	}
	public String getConfig_string(String key) {
		return FileUtils.readConfigValue_string(this, key);
	}
	
	public void setGuiFeatureData(GuiFeatureData data) {
		if(this.guiFeatureData != null) {
			this.guiFeatureData = data;
			
			setConfig("posX", data.getPosX());
			setConfig("posY", data.getPosY());
			setConfig("color", data.getColor());
			setConfig("scale", data.getScale());
			
			return;
		}
		
		System.err.println("Feature " + name + " does not have gui feature data!");
	}
}
