package com.ttnd.linksharing.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

	public static byte[] getBytes(String filePath) throws IOException {

		byte[] data = null;
		Path path = Paths.get(filePath);
		try {
			data = Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
