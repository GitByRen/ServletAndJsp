package com.important.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * InputStream inputStream = request.getInputStream(); BufferedReader
		 * bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		 * String str = null; while((str = bufferedReader.readLine()) != null) {
		 * System.out.println(str); }
		 */

		// commons-fileupload的方式上传
		// 1.得到FileItem的集合
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Set factory constraints
		factory.setSizeThreshold(1024 * 500);
		File tempDirectory = new File("D:\\tempDirectory");
		factory.setRepository(tempDirectory);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraint
		upload.setSizeMax(1024 * 1024 * 5);

		// Parse the request
		try {
			List<FileItem> items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		// 2.遍历items：若是一个一般的表单域，打印信息

		// 若是文件域，则把文件保存
	}

}
