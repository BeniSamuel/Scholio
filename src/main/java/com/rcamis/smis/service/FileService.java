package com.rcamis.smis.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    @Value("${uploads.dir}")
    private String uploadDir;

    public void uploadFile (MultipartFile reportFile) throws IOException {

    }
}
