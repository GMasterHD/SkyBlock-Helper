package io.github.gmasterhd.skyblockhelper.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class APIRequests {
	public static JsonObject request(String url) {
		System.out.println("API Request: " + url);
		
		InputStream is = null;
		try {
			is = new URL(url).openStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
			String jsonText = readAll(rd);
			JsonObject jsonObject = new JsonParser().parse(jsonText).getAsJsonObject();
			
			return jsonObject;
		} catch(IOException e) {
			return null;
		}
	}
	
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
}
