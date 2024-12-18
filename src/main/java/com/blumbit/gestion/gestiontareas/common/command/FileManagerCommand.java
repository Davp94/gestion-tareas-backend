package com.blumbit.gestion.gestiontareas.common.command;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileManagerCommand {
    
    @Value("${file.upload.dir}")
    private String uploadDir;

    public String execute(MultipartFile file){
        //validate file
        if(validateFileType(file) == false){ //true //false
            throw new RuntimeException("Tipo de archivo no permitido. El formato debe ser PNG o JPG");
        }
           
        String fileName = generateUniqueFilename(file.getOriginalFilename());
        Path filePath = Paths.get(uploadDir)
                        .toAbsolutePath().normalize();
        try {
            Files.createDirectories(filePath);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el directorio de carga de archivos", e);
        }
        try {
            Files.copy(file.getInputStream(), filePath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el archivo", e);
        }
        //create unique name 
    }

    private String generateUniqueFilename(String originalFileName){
        String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
        return timestamp+"_"+UUID.randomUUID().toString().substring(0,8)+"_"
        +originalFileName; 
    }

    private boolean validateFileType(MultipartFile file){
        if(file.getSize() > 5 * 1024 * 1024){
            throw new RuntimeException("Archivo muy grande. Maximo tamaño permitido 5MB");
        }
        String contentType = file.getContentType();
        return contentType.equals(MediaType.IMAGE_JPEG_VALUE) || contentType.equals(MediaType.IMAGE_PNG_VALUE);
    }
}
