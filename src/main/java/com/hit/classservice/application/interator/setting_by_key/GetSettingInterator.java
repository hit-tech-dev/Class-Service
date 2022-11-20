package com.hit.classservice.application.interator.setting_by_key;

import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.SettingByKeyRepository;
import com.hit.classservice.application.input.setting_by_key.GetSettingByKeyInput;
import com.hit.classservice.application.input_boundary.setting_by_key.GetSettingByKeyDataCase;
import com.hit.classservice.application.mapper.SettingByKeyMapper;
import com.hit.classservice.application.output.setting_by_key.GetSettingByKeyOutput;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Setting;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service("ApplicationGetSettingInterator")
public class GetSettingInterator implements GetSettingByKeyDataCase {

  private final SettingByKeyRepository settingByKeyRepository;
  private final SettingByKeyMapper settingByKeyMapper;

  public GetSettingInterator(SettingByKeyRepository settingByKeyRepository) {
    this.settingByKeyRepository = settingByKeyRepository;
    this.settingByKeyMapper = Mappers.getMapper(SettingByKeyMapper.class);
  }

  @SneakyThrows
  @Override
  public GetSettingByKeyOutput handle(GetSettingByKeyInput input) {

    Setting settingByKey = settingByKeyRepository.getSettingByKey(input.getKey());
    if (ObjectUtils.isEmpty(settingByKey)) {
      throw new VsException(UserMessageConstant.SettingByKey.ERR_NOT_FOUND_SETTING_BY_KEY,
          String.format(DevMessageConstant.SettingByKey.ERR_NOT_FOUND_BY_KEY, input.getKey()),
          new String[]{input.getKey()});
    }
    return settingByKeyMapper.toGetSettingByKeyOutput(settingByKey);
  }
}
