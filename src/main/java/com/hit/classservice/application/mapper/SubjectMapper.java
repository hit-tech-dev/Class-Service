package com.hit.classservice.application.mapper;

import com.hit.classservice.adapter.web.v1.transfer.parameter.subject.CreateSubjectParam;
import com.hit.classservice.adapter.web.v1.transfer.parameter.subject.UpdateSubjectParameter;
import com.hit.classservice.application.input.subject.CreateSubjectInput;
import com.hit.classservice.application.input.subject.UpdateSubjectInput;
import com.hit.classservice.application.output.subject.GetListSubjectItemOutput;
import com.hit.classservice.application.output.subject.GetSubjectOutput;
import com.hit.classservice.domain.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    @Mappings({
            @Mapping(target = "id", source = "subject.id"),
            @Mapping(target = "name", source = "subject.name"),
            @Mapping(target = "avatar", source = "subject.avatar"),
            @Mapping(target = "description", source = "subject.description")
    })
    GetListSubjectItemOutput toGetListSubjectItemOutput(Subject subject);

    List<GetListSubjectItemOutput> toGetListSubjectItemOutput(List<Subject> subjects);

    @Mappings({
            @Mapping(target = "id", source = "subject.id"),
            @Mapping(target = "name", source = "subject.name"),
            @Mapping(target = "avatar", source = "subject.avatar"),
            @Mapping(target = "description", source = "subject.description")
    })
    GetSubjectOutput toGetSubjectOutput(Subject subject);

    @Mappings({
            @Mapping(target = "id", source = "parameter.id"),
            @Mapping(target = "name", source = "parameter.name"),
            @Mapping(target = "avatar", source = "parameter.avatar"),
            @Mapping(target = "description", source = "parameter.description")
    })
    UpdateSubjectInput toUpdateSubjectInput(UpdateSubjectParameter parameter);

    @Mappings({
            @Mapping(target = "name", source = "createSubjectParam.name"),
            @Mapping(target = "file", source = "createSubjectParam.file"),
            @Mapping(target = "description", source = "createSubjectParam.description") ,
            @Mapping(target = "categoryId", source = "createSubjectParam.categoryId")})
    CreateSubjectInput toCreateSubjectInput(CreateSubjectParam createSubjectParam);
}
