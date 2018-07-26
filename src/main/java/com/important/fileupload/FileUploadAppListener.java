package com.important.fileupload;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class FileUploadAppListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("upload.properties");
		Properties properties = new Properties();
		try {
			properties.load(resourceAsStream);

			for (Map.Entry<Object, Object> prop : properties.entrySet()) {
				String propertyName = (String) prop.getKey();
				String propertyValue = (String) prop.getValue();
				FileUploadUtils.getInstance().setProperty(propertyName, propertyValue);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
