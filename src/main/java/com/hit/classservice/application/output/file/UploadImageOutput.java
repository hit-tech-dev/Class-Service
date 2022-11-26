package com.hit.classservice.application.output.file;

import com.hit.classservice.application.output.Output;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UploadImageOutput implements Output {

  private boolean status;

  private String message;

  private String pathImage;
}
