package com.tarkaris.recipe_app_backend.features.vegetable.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Value("${IMAGE_HOST}")
    private String image_host;

//    public String saveFile(MultipartFile file) {
//        try {
//            // Ensure the upload directory exists
//            java.nio.file.Path uploadPath = java.nio.file.Paths.get(uploadDir);
//            if (!java.nio.file.Files.exists(uploadPath)) {
//                java.nio.file.Files.createDirectories(uploadPath);
//            }
//
//            // Create a unique filename
//            String originalFilename = file.getOriginalFilename();
//            String fileExtension = "";
//            if (originalFilename != null && originalFilename.contains(".")) {
//                fileExtension = originalFilename.substring(originalFilename.lastIndexOf('.'));
//            }
//            String uniqueFilename = java.util.UUID.randomUUID().toString() + fileExtension;
//
//            // Save the file to the upload directory
//            java.nio.file.Path filePath = uploadPath.resolve(uniqueFilename);
//            file.transferTo(filePath.toFile());
//
//            return uniqueFilename;
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to store file " + file.getOriginalFilename(), e);
//        }

        public String saveFile(MultipartFile file) {
            try {
                Path directory = Paths.get(uploadDir).toAbsolutePath().normalize();
                Files.createDirectories(directory);

                String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
                Path targetPath = directory.resolve(filename);
                Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

                // Return relative URL path (for frontend access)
                return image_host + "/images/vegetables/" + filename;
            } catch (IOException ex) {
                throw new RuntimeException("Could not store file: " + file.getOriginalFilename(), ex);
            }
        }
    }





