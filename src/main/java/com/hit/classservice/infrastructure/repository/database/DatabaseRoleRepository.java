package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.RoleRepository;
import com.hit.classservice.domain.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("DatabaseRoleRepository")
public interface DatabaseRoleRepository extends RoleRepository {

  @Override
  Role findById(@Param("id")Long id);

  @Override
  Role findByName(@Param("name")String name);

  @Override
  int update(@Param("item")Role role);

}
