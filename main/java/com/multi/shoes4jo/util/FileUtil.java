package com.multi.shoes4jo.util;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import com.multi.shoes4jo.vo.BoardVO;
import com.multi.shoes4jo.vo.FreeBoardVO;

public class FileUtil {
	public static String FileUpload(FreeBoardVO vo, MultipartFile file, HttpSession session) throws IOException {
		String newFileName = null;
		if (file != null && !file.isEmpty()) {
			String originalFilename = file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(originalFilename);
			newFileName = System.currentTimeMillis() + "." + extension;

			vo.setFile_name(originalFilename);
			vo.setFile_path(newFileName);

			java.io.File newFile = new java.io.File(session.getServletContext().getRealPath("assets/img/"),
					newFileName);

			FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);

			System.out.println("파일 저장 성공: " + newFile.getAbsolutePath());
		}
		return newFileName;
	}

	public static String FileUpload(BoardVO vo, MultipartFile file, HttpSession session) throws IOException {
		String newFileName = null;
		if (file != null && !file.isEmpty()) {
			String originalFilename = file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(originalFilename);
			newFileName = System.currentTimeMillis() + "." + extension;

			vo.setFile_name(originalFilename);
			vo.setFile_path(newFileName);

			java.io.File newFile = new java.io.File(session.getServletContext().getRealPath("assets/img/"),
					newFileName);

		    FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);

		    System.out.println("파일 저장 성공: " + newFile.getAbsolutePath());
	    }
	    return newFileName;
    }
}
