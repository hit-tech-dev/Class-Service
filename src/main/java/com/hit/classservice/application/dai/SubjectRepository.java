package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.Subject;

import java.util.List;

public interface SubjectRepository {

    List<Subject> findAll();

    Subject findById(Long id);

    int update(Subject subject);

    Subject findByName(String name);

    int delete(Long id);
}
