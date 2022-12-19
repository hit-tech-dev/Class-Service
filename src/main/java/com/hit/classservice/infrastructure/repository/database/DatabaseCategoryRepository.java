package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.CategoryRepository;
import com.hit.classservice.application.output.common.PagingMeta;
import com.hit.classservice.domain.dto.CategoryDto;
import com.hit.classservice.domain.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("DatabaseCategoryRepository")
public interface DatabaseCategoryRepository extends CategoryRepository {

  @Override
  long countSearchCategory(@Param("keyword") String keyword);

  @Override
  List<CategoryDto> searchCategory(@Param("keyword") String keyword, @Param("meta") PagingMeta meta);

  @Override
  List<Category> getAllCategory();

  @Override
  Category findById(@Param("id") Long id);

  @Override
  Category findByName(@Param("name") String name);

  @Override
  int save(@Param("item") Category category);

  @Override
  int update(@Param("item") Category category);

  @Override
  int delete(@Param("id") Long id);

}
