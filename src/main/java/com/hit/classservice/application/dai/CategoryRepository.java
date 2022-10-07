package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.Category;

import java.util.List;

public interface CategoryRepository {

  List<Category> findAll();

  Category findById(Long id);

  Category findByName(String name);

  int save(Category category);

  int update(Category category);

  int delete(Long id);

}
