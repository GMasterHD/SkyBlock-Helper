package io.github.gmasterhd.skyblockhelper.utils;

import com.google.gson.JsonObject;
import io.github.gmasterhd.skyblockhelper.SkyBlockHelper;
import io.github.gmasterhd.skyblockhelper.main.Feature;

public class FileUtils {
	public static void setConfigValue(Feature f, String key, int value) {
		JsonObject v = new JsonObject();
		v.addProperty(key, value);
		
		if(SkyBlockHelper.saves.Features.has(f.getId() + "")) {
			//SkyBlockHelper.saves.getAsJsonObject(f.getId() + "").remove(key);
			SkyBlockHelper.saves.Features.getAsJsonObject(f.getId() + "").addProperty(key, value);
		} else {
			SkyBlockHelper.saves.Features.add(f.getId() + "", v);
		}
	}
	public static void setConfigValue(Feature f, String key, String value) {
		JsonObject v = new JsonObject();
		v.addProperty(key, value);
		
		if(SkyBlockHelper.saves.Features.has(f.getId() + "")) {
			//SkyBlockHelper.saves.getAsJsonObject(f.getId() + "").remove(key);
			SkyBlockHelper.saves.Features.getAsJsonObject(f.getId() + "").addProperty(key, value);
		} else {
			SkyBlockHelper.saves.Features.add(f.getId() + "", v);
		}
	}
	public static void setConfigValue(Feature f, String key, float value) {
		JsonObject v = new JsonObject();
		v.addProperty(key, value);
		
		if(SkyBlockHelper.saves.Features.has(f.getId() + "")) {
			//SkyBlockHelper.saves.getAsJsonObject(f.getId() + "").remove(key);
			SkyBlockHelper.saves.Features.getAsJsonObject(f.getId() + "").addProperty(key, value);
		} else {
			SkyBlockHelper.saves.Features.add(f.getId() + "", v);
		}
	}
	public static void setConfigValue(Feature f, String key, boolean value) {
		JsonObject v = new JsonObject();
		v.addProperty(key, value);
		
		if(SkyBlockHelper.saves.Features.has(f.getId() + "")) {
			//SkyBlockHelper.saves.getAsJsonObject(f.getId() + "").remove(key);
			SkyBlockHelper.saves.Features.getAsJsonObject(f.getId() + "").addProperty(key, value);
		} else {
			SkyBlockHelper.saves.Features.add(f.getId() + "", v);
		}
	}
	
	public static int readConfigValue_int(Feature f, String key) {
		return SkyBlockHelper.saves.Features.getAsJsonObject(f.getId() + "").get(key).getAsInt();
	}
	public static String readConfigValue_string(Feature f, String key) {
		return SkyBlockHelper.saves.Features.getAsJsonObject(f.getId() + "").get(key).getAsString();
	}
	public static boolean readConfigValue_boolean(Feature f, String key) {
		return SkyBlockHelper.saves.Features.getAsJsonObject(f.getId() + "").get(key).getAsBoolean();
	}
	public static float readConfigValue_float(Feature f, String key) {
		return SkyBlockHelper.saves.Features.getAsJsonObject(f.getId() + "").get(key).getAsFloat();
	}
	
	public static boolean hasValue(JsonObject obj, String key) {
		return obj.has(key);
	}
}
