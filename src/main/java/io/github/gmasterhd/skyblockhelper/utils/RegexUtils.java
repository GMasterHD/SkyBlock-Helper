package io.github.gmasterhd.skyblockhelper.utils;

import java.util.regex.Pattern;

public class RegexUtils {
	// Code decompiled (Original by Biscuit from SkyBlock Addons)
	
	public static final transient Pattern SIDEBAR_PLAYER_NAME_PATTERN = Pattern.compile("[\ud83d\udd2b\ud83c\udf6b\ud83d\udca3\ud83d\udc7d\ud83d\udd2e\ud83d\udc0d\ud83d\udc7e\ud83c\udf20\ud83c\udf6d\u26bd\ud83c\udfc0\ud83d\udc79\ud83c\udf81\ud83c\udf89\ud83c\udf82]+");
	
	public static String replace(String message, Pattern pattern, String replace) {
		return pattern.matcher(message).replaceAll(replace);
	}
	
	public static String strip(String message, Pattern pattern) {
		return replace(message, pattern, "");
	}
}
