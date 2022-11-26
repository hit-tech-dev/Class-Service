package com.hit.classservice.application.utils;

import com.hit.classservice.config.exception.VsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class WebClientUtil {

  private static final WebClient webClient;

  static {
    webClient = BeanUtil.getBean(org.springframework.web.reactive.function.client.WebClient.class);
  }

  public static Mono<?> findById(String uri, Class<?> clazz) {
    return webClient.get()
        .uri(uri)
        .retrieve()
        .bodyToMono(clazz);
  }

  public static Mono<?> uploadFile(String uri, MultipartFile file, Class<?> clazz) {
    MultipartBodyBuilder builder = new MultipartBodyBuilder();
    builder.part("file", file.getResource());
    return webClient.post()
        .uri(uri)
        .contentType(MediaType.MULTIPART_FORM_DATA)
        .body(BodyInserters.fromMultipartData(builder.build())).retrieve().bodyToMono(clazz);
  }

  public static Mono<?> uploadFileStatus(String uri, MultipartFile file, Class<?> clazz) {
    MultipartBodyBuilder builder = new MultipartBodyBuilder();
    builder.part("file", file.getResource());
    return webClient.post()
        .uri(uri)
        .contentType(MediaType.MULTIPART_FORM_DATA)
        .body(BodyInserters.fromMultipartData(builder.build()))
        .exchangeToMono(res -> {
          if (res.statusCode().equals(HttpStatus.OK)) {
            return res.bodyToMono(HttpStatus.class).thenReturn(res.statusCode());
          } else {
            throw new VsException("Error uploading file", "Error uploading file");
          }
        });
  }
}
