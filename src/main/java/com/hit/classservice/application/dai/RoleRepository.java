package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.Role;

public interface RoleRepository {

  Role findById(Long id);

  Role findByName(String name);

  int update(Role role);
}


