package com.important.fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

	private FileUploadUtils instance = FileUploadUtils.getInstance();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletFileUpload upload = getServletFileUpload();
		String path = "";

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
			// 6.删除临时文件
			deleteTemp(items);

			path = "/UpAndDown/down.jsp";
		} catch (FileUploadException e) {
			request.setAttribute("msg", e.getMessage());
			path = "/UpAndDown/upload.jsp";
			e.printStackTrace();
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * 删除缓存文件
	 * 
	 * @param items
	 */
	private void deleteTemp(List<FileItem> items) {
		for (FileItem fileItem : items) {
			fileItem.delete();
		}
	}

	/**
	 * 保存至数据库
	 * 
	 * @param beans
	 */
	private void saveBeans(List<FileUploadBean> beans) {

	}

	/**
	 * 文件上传准备
	 * 
	 * @param uploadFiles
	 * @throws IOException
	 */
	private void upload(Map<String, FileItem> uploadFiles) throws IOException {
		for (Entry<String, FileItem> maps : uploadFiles.entrySet()) {
			String path = maps.getKey();
			FileItem item = maps.getValue();

			upload(path, item.getInputStream());
		}
	}

	/**
	 * 文件上传
	 * 
	 * @param path
	 * @param inputStream
	 * @throws IOException
	 */
	private void upload(String path, InputStream inputStream) throws IOException {
		OutputStream os = new FileOutputStream(path);

		int len = 0;
		byte[] buffer = new byte[1024];
		while ((len = inputStream.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}

		os.close();
		inputStream.close();
	}

	/**
	 * 校验扩展名是否合法
	 * 
	 * @param beans
	 * @throws FileUploadException
	 */
	private void validateExtName(List<FileUploadBean> beans) throws FileUploadException {
		String exts = instance.getProperty("exts");
		List<String> extList = Arrays.asList(exts.split(","));

		for (FileUploadBean fileUploadBean : beans) {
			String fileName = fileUploadBean.getFileName();
			String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
			if (!extList.contains(extName)) {
				throw new FileUploadException(fileName + "文件的扩展名不合法!");
			}
		}
	}

	/**
	 * 利用传入的FileItem集合，构建FileUploadBean的集合
	 * 
	 * @param items
	 * @param uploadFiles
	 * @return
	 */
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
	 * 得到随机的文件的路径和文件名
	 * 
	 * @param fileName
	 * @return
	 */
	private String getFilePath(String fileName) {
		String extName = fileName.substring(fileName.lastIndexOf("."));
		int randomNum = (int) (Math.random() * 100000);
		String filePath = getServletContext().getRealPath(FILE_PATH) + "\\" + System.currentTimeMillis() + randomNum
				+ extName;
		return filePath;
	}

	/**
	 * 构建了ServletFileUpload对象，从配置文件读取部分属性，用户设置约束
	 * 
	 * @return
	 */
	private ServletFileUpload getServletFileUpload() {
		String fileMaxSize = instance.getProperty("file.max.size");
		String totalFileMaxSize = instance.getProperty("total.file.max.size");

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024);
		File tempDirectory = new File("E:\\tempDirectory");
		factory.setRepository(tempDirectory);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(Long.parseLong(fileMaxSize));
		upload.setSizeMax(Long.parseLong(totalFileMaxSize));
		return upload;
	}

}
