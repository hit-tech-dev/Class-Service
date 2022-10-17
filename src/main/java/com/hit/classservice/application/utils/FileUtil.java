package com.hit.classservice.application.utils;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class FileUtil {

  private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

  @SneakyThrows
  public String uploadFile(MultipartFile multipartFile) {
    Path staticPath = Paths.get("static");
    Path imagePath = Paths.get("images");
    if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
      Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
      Files.createDirectories(CURRENT_FOLDER);
    }
    Path file = CURRENT_FOLDER.resolve(staticPath)
        .resolve(imagePath).resolve(Objects.requireNonNull(multipartFile.getOriginalFilename()));
    try (OutputStream os = Files.newOutputStream(file)) {
      os.write(multipartFile.getBytes());
    }
    return imagePath.resolve(multipartFile.getOriginalFilename()).toString();
  }
}
