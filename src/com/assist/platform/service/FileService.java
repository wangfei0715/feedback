package com.assist.platform.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import jcifs.smb.SmbAuthException;

public interface FileService {

	/**
	 * 获取文件存储路径
	 * 
	 * @param fileuuid
	 */
	public abstract void getFilePath(String fileuuid);

	/**
	 * 上传文件
	 * 
	 * @param file
	 * @return
	 */
	public abstract String uploadFile(List<File> files,
			List<String> uploadFileName, List<String> uploadContentType)
			throws SmbAuthException, Exception;

	/**
	 * 下载文件
	 * 
	 * @param fileuuid
	 * @return
	 */
	public abstract InputStream downloadFile(String fileuuid);

	/**
	 * 判断文件是否存在
	 * 
	 * @param fileuuid
	 * @return
	 */
	public abstract boolean isExist(String fileuuid);

}
