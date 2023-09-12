package com.multi.shoes4jo.util;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import com.multi.shoes4jo.board.BoardVO;
import com.multi.shoes4jo.freeboard.FreeBoardVO;

public class FileUtil {
	public static void FileUpload(FreeBoardVO vo, MultipartFile file, HttpSession session) throws IOException {
		if (file != null && !file.isEmpty()) {
			String originalFilename = file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(originalFilename);
			String newFileName = System.currentTimeMillis() + "." + extension;

			vo.setFile_name(originalFilename);
			vo.setFile_path(newFileName);

			java.io.File newFile = new java.io.File(session.getServletContext().getRealPath("assets/img/"),
					newFileName);

			FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);

			System.out.println("파일 저장 성공: " + newFile.getAbsolutePath());
		}
	}

	public static void FileUpload(BoardVO vo, MultipartFile file, HttpSession session) throws IOException {
		if (file != null && !file.isEmpty()) {
			String originalFilename = file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(originalFilename);
			String newFileName = System.currentTimeMillis() + "." + extension;

			vo.setFile_name(originalFilename);
			vo.setFile_path(newFileName);

			java.io.File newFile = new java.io.File(session.getServletContext().getRealPath("assets/img/"),
					newFileName);

			FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);

			System.out.println("파일 저장 성공: " + newFile.getAbsolutePath());
		}
	}
}
