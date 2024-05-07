package com.ahmedtiba.book.file;

import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.io.File.separator;
import static java.lang.System.currentTimeMillis;


@Service
@Slf4j
@RequiredArgsConstructor
public class FileStorageService {

    @Value("${application.file.uploads.photos-output-path}")
    private String fileUploadPath;

    public String saveFile(@Nonnull MultipartFile sourceFile, @Nonnull String userId) {
        final String fileUploadSubPath = "users" + separator + userId;
        return uploadFile(sourceFile, fileUploadSubPath);
    }

    private String uploadFile(@Nonnull MultipartFile sourceFile, @Nonnull String fileUploadSubPath) {
        // Create the final path where the file will be uploaded
        final String finalUploadPath = fileUploadPath + separator + fileUploadSubPath;
        // Create an object representing the target folder
        File targetFolder = new File(finalUploadPath);

        // Check if the target folder doesn't exist
        if (!targetFolder.exists()) {
            // Create the target folder if it doesn't already exist
            boolean folderCreated = targetFolder.mkdirs();
            // If creating the folder fails, log a warning
            if (!folderCreated) {
                log.warn("Failed to create the target folder: " + targetFolder);
                return null;
            }
        }
        // Get the file extension of the source file
        final String fileExtension = getFileExtension(sourceFile.getOriginalFilename());
        // Create the full path for the target file
        String targetFilePath = finalUploadPath + separator + currentTimeMillis() + "." + fileExtension;
        // Create a Path object from the target file path
        Path targetPath = Paths.get(targetFilePath);
        try {
            // Write the bytes of the source file to the target file
            Files.write(targetPath, sourceFile.getBytes());
            // Log an info message indicating that the file was saved successfully
            log.info("File saved to: " + targetFilePath);
            // Return the path of the target file to indicate successful upload
            return targetFilePath;
        } catch (IOException e) {
            // In case of an error while writing the file, log an error with the exception details
            log.error("File was not saved", e);
        }
        // Return null to indicate that there was an error while writing the file
        return null;
    }

    // Method to retrieve the extension of a file name
    private String getFileExtension(String fileName) {
        // Check if the file name is null or empty
        if (fileName == null || fileName.isEmpty()) {
            return "";
        }
        // Get the index of the last dot in the file name
        int lastDotIndex = fileName.lastIndexOf(".");
        // If no dot is found, return an empty string
        if (lastDotIndex == -1) {
            return "";
        }
        // Return the file extension in lowercase
        return fileName.substring(lastDotIndex + 1).toLowerCase();
    }

}
