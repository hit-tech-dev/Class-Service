package com.hit.classservice.application.mapper;

import com.hit.classservice.application.output.category.GetCategoryOutput;
import com.hit.classservice.application.output.category.GetListCategoryItemOutput;
import com.hit.classservice.domain.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  @Mappings({
      @Mapping(target = "id", source = "category.id"),
      @Mapping(target = "name", source = "category.name"),
      @Mapping(target = "description", source = "category.description")
  })
  GetListCategoryItemOutput toGetListCategoryItemOutput(Category category);

  List<GetListCategoryItemOutput> toGetListCategoryItemOutputs(List<Category> categories);

  @Mappings({
      @Mapping(target = "id", source = "category.id"),
      @Mapping(target = "name", source = "category.name"),
      @Mapping(target = "description", source = "category.description")
  })
  GetCategoryOutput toGetCategoryOutput(Category category);

}
