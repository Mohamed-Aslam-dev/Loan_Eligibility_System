package com.loan_eligibility_system_homeloan.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class HomeloanDocumentsStoredService {
	
	public String saveFile(MultipartFile file, String uploadDir) {

		try {
			if (file.isEmpty())
				return null;

			Path uploadPath = Paths.get(uploadDir);
			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			
			String originalFileName = file.getOriginalFilename();
			String uniqueFileName = UUID.randomUUID().toString() + "_" + originalFileName;
			
			Path filePath = uploadPath.resolve(uniqueFileName);
			Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

			return filePath.toString();
		} catch (IOException fileException) {
			throw new RuntimeException("File save failed: " + file.getOriginalFilename(), fileException);
		}
	}

}
