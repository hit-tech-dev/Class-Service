package com.hit.classservice.application.mapper;

import com.hit.classservice.application.output.setting_by_key.GetSettingByKeyOutput;
import com.hit.classservice.domain.entity.Setting;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SettingByKeyMapper {

  @Mappings({
      @Mapping(target = "id", source = "settingByKey.id"),
      @Mapping(target = "key", source = "settingByKey.key"),
      @Mapping(target = "value", source = "settingByKey.value"),
  })
  GetSettingByKeyOutput toGetSettingByKeyOutput(Setting settingByKey);
}
