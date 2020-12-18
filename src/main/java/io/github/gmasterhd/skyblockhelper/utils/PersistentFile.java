package io.github.gmasterhd.skyblockhelper.utils;

import com.google.gson.*;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PersistentFile<T> {
	public String filePath = "";

	public T predefinedValues;

	public PersistentFile(String path) {
		System.out.println(path);
		filePath = path;
	}
	
	public PersistentFile(String path, T predefinedValues) {
		this.filePath = path;

		if(!new File(filePath).exists()) {
			save(predefinedValues);
		}
	}

	public void save(T values) {
		File file = new File(filePath.substring(0, filePath.lastIndexOf('/')));

		System.out.println("Creating Directory: " + file.toPath());
		file.mkdirs();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonSRC = gson.toJson(values);
		try {
			Files.write(Paths.get(filePath), jsonSRC.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public T load(Class<T> c) {
		if(!new File(filePath).exists()) {
			System.out.println("Could not find save file!");
			return new Gson().fromJson(new Gson().toJson(predefinedValues, c), c);
		}
		String content;
		try {
			content = readFile(filePath, StandardCharsets.UTF_8);
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		}

		return new Gson().fromJson(content, c);
	}

	static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}
