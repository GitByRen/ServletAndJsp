package com.important.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String FILE_PATH = "/WEB-INF/files";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		ServletFileUpload upload = getServletFileUpload();

		try {
			// 把需要上传的FileItem都放入到该Map中
			Map<String, FileItem> uploadFiles = new HashMap<>();
			List<FileItem> items = upload.parseRequest(request);
			// 1.构建FileUploadBean集合,同时填充uploadFiles
			List<FileUploadBean> beans = buildUploadBeans(items, uploadFiles);
			// 2.校验扩展名
			validateExtName(beans);
			// 3.校验文件大小：在解析时已经校验了，我们只需要通过异常得到结果
			// 4.上传
			upload(uploadFiles);
			// 5.保存信息到数据库
			saveBeans(beans);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	private void saveBeans(List<FileUploadBean> beans) {

	}

	private void upload(Map<String, FileItem> uploadFiles) {

	}

	private void validateExtName(List<FileUploadBean> beans) {

	}

	private List<FileUploadBean> buildUploadBeans(List<FileItem> items, Map<String, FileItem> uploadFiles) {
		List<FileUploadBean> beans = new ArrayList<>();

		// 1.遍历items,保存desc
		Map<String, String> descs = new HashMap<>();
		for (FileItem fileItem : items) {
			if (fileItem.isFormField()) {
				descs.put(fileItem.getFieldName(), fileItem.getString());
			}
		}

		// 2.再遍历FileItem,得到FileItem对象,获取文件信息
		for (FileItem item : items) {
			if (!item.isFormField()) {
				// <input name='file1...'/>
				String fieldName = item.getFieldName();
				String index = fieldName.substring(fieldName.length() - 1);

				String fileName = item.getName();
				String desc = descs.get("desc" + index);
				String filePath = getFilePath(fileName);
				FileUploadBean bean = new FileUploadBean(fileName, filePath, desc);
				beans.add(bean);

				uploadFiles.put(filePath, item);
			}
		}

		return beans;
	}

	/**
	 * 得到文件的路径
	 * @param fileName
	 * @return
	 */
	private String getFilePath(String fileName) {
		String extName = fileName.substring(fileName.lastIndexOf("."));
		String filePath = getServletContext().getRealPath(FILE_PATH) + "\\" + System.currentTimeMillis() + extName;
		return filePath;
	}

	private ServletFileUpload getServletFileUpload() {
		FileUploadUtils instance = FileUploadUtils.getInstance();
		String exts = instance.getProperty("exts");
		String fileMaxSize = instance.getProperty("file.max.size");
		String totalFileMaxSize = instance.getProperty("total.file.max.size");

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 500);
		File tempDirectory = new File("E:\\tempDirectory");
		factory.setRepository(tempDirectory);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(Long.parseLong(fileMaxSize));
		upload.setSizeMax(Long.parseLong(totalFileMaxSize));
		return upload;
	}

}
