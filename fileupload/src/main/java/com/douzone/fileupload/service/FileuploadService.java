package com.douzone.fileupload.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileuploadService {
	private static String SAVE_PATH = "/Users/yoon/fileupload-files";	// 저장 경로(Windows는 "/fileupload-files" 이렇게만)
	private static String URL_PATH = "/images";	// 코드상으로 Mapping 되는 곳
	
	public String restore(MultipartFile file) {
		String url = null;
		
		try {
			File uploadDirectory = new File(SAVE_PATH);
			if(!uploadDirectory.exists()) {
				uploadDirectory.mkdirs();
			}
			
			if(file.isEmpty()) {	// 파일이 업로드 되지 않았을 때
				return url;			// null을 리턴
			}
			
			String originFilename = file.getOriginalFilename();	// 사용자가 업로드한 파일 이름 ex/ profile.jpeg
			String extName = originFilename.substring(originFilename.lastIndexOf(".")+1);	// 뒤에서부터 .을 찾아보고 / +1: . 다음부터의 문자를 뽑아낸다 ex/ jpeg
			String saveFilename = generateSaveFilename(extName);
			Long fileSize = file.getSize();
			
			System.out.println("##########" + originFilename);
			System.out.println("##########" + saveFilename);
			System.out.println("##########" + fileSize);	
			
			byte[] data = file.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
			os.write(data);
			os.close();
			
			url = URL_PATH + "/" + saveFilename; 
		} catch(IOException ex) {
			throw new FileuploadServiceException(ex.toString());
		}
		
		return url;
	}

	private String generateSaveFilename(String extName) {
		String filename = "";
		
		Calendar calendar = Calendar.getInstance();
		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += ("." + extName);
		
		return filename;
	}

}