package com.important.fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

		// 设置内存中最多可以存放的上传文件的大小，若超出则把文件写到一个临时文件夹,以byte为单位
		factory.setSizeThreshold(1024 * 500);
		File tempDirectory = new File("E:\\tempDirectory");
		factory.setRepository(tempDirectory);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 设置上传文件的总的大小，也可以设置单个文件的大小.
		upload.setSizeMax(1024 * 1024 * 5);

		// Parse the request
		try {
		    // commons-fileupload可以解析请求，得到一个FileItem对象组成的List
			List<FileItem> items = upload.parseRequest(request);
			// 2.遍历items：若是一个一般的表单域，打印信息
			for (FileItem fileItem : items) {
				if (fileItem.isFormField()) {
					String name = fileItem.getFieldName();
					String value = fileItem.getString();
					System.out.println(name + " " + value);
				} else {
					// 若是文件域，则把文件保存
					String fieldName = fileItem.getFieldName();
					String fileName = fileItem.getName();
					String contentType = fileItem.getContentType();
					boolean inMemory = fileItem.isInMemory();
					long size = fileItem.getSize();
					System.out.println(fieldName + " " + fileName + " " + contentType + " " + inMemory + " " + size);
					
					InputStream inputStream = fileItem.getInputStream();
					fileName = "E:\\dir" + fileName;
					OutputStream out = new FileOutputStream(fileName);
					
					byte[] buf = new byte[1024];
					int len = 0;
					while((len = inputStream.read(buf)) != -1) {
						out.write(buf, 0, len);
					}
					out.close();
					inputStream.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

	}

}
