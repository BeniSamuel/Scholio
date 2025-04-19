package com.rcamis.smis.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import java.io.IOException;

@Service
public class FileService {

    @Value("${uploads.dir}")
    private String uploadDir;

    public String uploadFile(MultipartFile reportFile) throws IOException {
        // Create directory if not exists
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Get the destination path
        String fileName = reportFile.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);

        // Copy the file to the destination
        Files.copy(reportFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return filePath.toString(); // Return full path or just file name
    }
}
