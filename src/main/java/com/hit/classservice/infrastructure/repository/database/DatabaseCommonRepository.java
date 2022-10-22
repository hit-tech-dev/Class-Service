package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.CommonRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("DatabaseCommonRepository")
public interface DatabaseCommonRepository extends CommonRepository {

  @Override
  Long findLastInsertId();

}
