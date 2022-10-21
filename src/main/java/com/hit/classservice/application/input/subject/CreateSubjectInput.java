package com.hit.classservice.application.input.subject;

import com.hit.classservice.application.input.Input;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSubjectInput implements Input {

  private String name;

  private MultipartFile file;

  private String description;

  private Long categoryId;

}
