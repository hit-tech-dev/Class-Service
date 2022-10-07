package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.CategoryRepository;
import com.hit.classservice.domain.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("DatabaseCategoryRepository")
public interface DatabaseCategoryRepository extends CategoryRepository {

  @Override
  List<Category> findAll();

  @Override
  Category findById(@Param("id") Long id);

  @Override
  boolean checkNameExist(@Param("name") String name);

  @Override
  int save(@Param("item") Category category);

}
