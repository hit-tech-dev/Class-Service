package com.hit.classservice.config.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class AccessDeniedException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  private HttpStatus status;
  private String userMessage;
  private String devMessage;

  public AccessDeniedException(String userMessage, String devMessage) {
    super(userMessage);
    this.status = HttpStatus.BAD_REQUEST;
    this.userMessage = userMessage;
    this.devMessage = devMessage;
  }

  public AccessDeniedException(HttpStatus status, String userMessage, String devMessage) {
    super(userMessage);
    this.status = status;
    this.userMessage = userMessage;
    this.devMessage = devMessage;
  }

}
