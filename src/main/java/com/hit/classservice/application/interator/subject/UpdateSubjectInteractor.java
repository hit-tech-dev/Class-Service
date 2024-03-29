package com.hit.classservice.application.interator.subject;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.SubjectRepository;
import com.hit.classservice.application.input.subject.UpdateSubjectInput;
import com.hit.classservice.application.input_boundary.subject.UpdateSubjectDataCase;
import com.hit.classservice.application.mapper.SubjectMapper;
import com.hit.classservice.application.output.subject.UpdateSubjectOutput;
import com.hit.classservice.application.utils.WebClientUtil;
import com.hit.classservice.config.exception.NotFoundException;
import com.hit.classservice.domain.entity.Subject;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service("ApplicationUpdateSubjectInteractor")
public class UpdateSubjectInteractor implements UpdateSubjectDataCase {
  private final SubjectRepository subjectRepository;
  private final SubjectMapper subjectMapper;

  public UpdateSubjectInteractor(@Qualifier("DatabaseSubjectRepository") SubjectRepository subjectRepository) {
    this.subjectRepository = subjectRepository;
    this.subjectMapper = Mappers.getMapper(SubjectMapper.class);
  }

  @SneakyThrows
  @Override
  public UpdateSubjectOutput handle(UpdateSubjectInput input) {
    //find subject by id
    Subject oldSubject = subjectRepository.findById(input.getId());
    if (ObjectUtils.isEmpty(oldSubject))
      throw new NotFoundException(UserMessageConstant.Subject.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Subject.ERR_NOT_FOUND_BY_ID, input.getId()),
          new String[]{input.getId().toString()});

    //check name unique
    Subject oldSubjectByName = subjectRepository.findByName(input.getName());
    if (ObjectUtils.isNotEmpty(oldSubjectByName) && !input.getId().equals(oldSubjectByName.getId()))
      return new UpdateSubjectOutput(CommonConstant.FALSE,
          String.format(DevMessageConstant.Subject.DUPLICATE_NAME, input.getName()));

    // Get path image
    if(!input.getFile().isEmpty()) {
      LinkedHashMap<String, Object> res = (LinkedHashMap<String, Object>)
          WebClientUtil.uploadFile(UrlConstant.UriConstant.UPLOAD_IMAGE_FILE,
              input.getFile(), Object.class).block();

      LinkedHashMap<String, Object> resData = (LinkedHashMap<String, Object>) res.get("data");
      String pathFile = resData.get("pathImage").toString();
      oldSubject.setAvatar(pathFile);
    }

    // Save subject
    oldSubject = subjectMapper.toSubject(input);
    subjectRepository.update(oldSubject);
    return new UpdateSubjectOutput(CommonConstant.TRUE, "Update successful");
  }

}
