package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.UserRepository;
import com.hit.classservice.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("DatabaseUserRepository")
public interface DatabaseUserRepository extends UserRepository {

  @Override
  User findById(@Param("id") String id);

}
