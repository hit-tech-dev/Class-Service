package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.Category;

import java.util.List;

public interface CategoryRepository {

  List<Category> findAll();

}
