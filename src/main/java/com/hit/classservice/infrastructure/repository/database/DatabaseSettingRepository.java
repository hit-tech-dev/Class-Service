package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.SettingByKeyRepository;
import com.hit.classservice.domain.entity.Setting;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("DatabaseSettingRepository")
public interface DatabaseSettingRepository extends SettingByKeyRepository {

  @Override
  Setting getSettingByKey(@Param("key") String keyword);

}
