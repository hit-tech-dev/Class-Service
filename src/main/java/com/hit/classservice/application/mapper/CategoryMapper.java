package com.hit.classservice.application.mapper;

import com.hit.classservice.adapter.web.v1.transfer.parameter.category.CreateCategoryParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.category.UpdateCategoryParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.common.PagingMetaParameter;
import com.hit.classservice.application.input.category.CreateCategoryInput;
import com.hit.classservice.application.input.category.GetListCategoryInput;
import com.hit.classservice.application.input.category.UpdateCategoryInput;
import com.hit.classservice.application.output.category.GetCategoryOutput;
import com.hit.classservice.application.output.category.GetListCategoryItemOutput;
import com.hit.classservice.domain.dto.CategoryDto;
import com.hit.classservice.domain.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  List<GetListCategoryItemOutput> toGetListCategoryItemOutputs(List<CategoryDto> categoryDtos);

  @Mappings({
      @Mapping(target = "id", source = "category.id"),
      @Mapping(target = "name", source = "category.name"),
      @Mapping(target = "description", source = "category.description")
  })
  GetCategoryOutput toGetCategoryOutput(Category category);

  CreateCategoryInput toCreateCategoryInput(CreateCategoryParameter parameter);

  UpdateCategoryInput toUpdateCategoryInput(UpdateCategoryParameter parameter);

  GetListCategoryInput toGetListCategoryInput(PagingMetaParameter parameter);

}
