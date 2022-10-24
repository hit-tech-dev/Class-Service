package com.hit.classservice.application.dai;

import com.hit.classservice.application.output.role.GetListRoleItemOutput;
import com.hit.classservice.domain.entity.Role;

import java.util.List;

public interface RoleRepository {

  Role findById(Long id);

  Role findByName(String name);

  int update(Role role);

  List<Role> findAll();


}


