package com.blumbit.gestion.gestiontareas.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Value("${file.upload.dir}")
    private String uploadDir;

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        Path absoluteUploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
        registry.addResourceHandler("/images/**").addResourceLocations("file:" + absoluteUploadPath + "/");
    }
}
