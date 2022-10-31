package com.hit.classservice.application.dai;

import com.hit.classservice.application.output.common.PagingMeta;
import com.hit.classservice.domain.dto.CategoryDto;
import com.hit.classservice.domain.entity.Category;

import java.util.List;

public interface CategoryRepository {

  long countSearchCategory(String keyword);

  List<CategoryDto> searchCategory(String keyword, PagingMeta meta);

  Category findById(Long id);

  Category findByName(String name);

  int save(Category category);

  int update(Category category);

  int delete(Long id);

}
