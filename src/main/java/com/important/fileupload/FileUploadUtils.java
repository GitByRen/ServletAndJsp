package com.important.fileupload;

import java.util.HashMap;
import java.util.Map;

public class FileUploadUtils {

	private Map<String, String> maps = new HashMap<>();

	private static FileUploadUtils fuu = new FileUploadUtils();

	private FileUploadUtils() {
	}

	public static FileUploadUtils getInstance() {
		return fuu;
	}

	public void setProperty(String propertyName, String propertyValue) {
		maps.put(propertyName, propertyValue);
	}

	public String getProperty(String propertyName) {
		return maps.get(propertyName);
	}
}
