package ru.vistar.kionmarket.product;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    public void saveFile(MultipartFile file, String directory, String fileName){
        Path path = Path.of(directory);
        Path filePath = path.resolve(fileName);
        try {
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] findFile(String directory, String fileName){
        Path path = Paths.get(directory + fileName);
        byte[] fileBytes;
        try {
            fileBytes = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException("image not loaded");
        }
        return fileBytes;
    }

    public boolean isFileExist(String directory, String fileName){
        File file = new File(directory + fileName);
        return file.exists() && !file.isDirectory();
    }
}
