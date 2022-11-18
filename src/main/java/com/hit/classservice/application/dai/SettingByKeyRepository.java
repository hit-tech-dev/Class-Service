package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.Setting;

public interface SettingByKeyRepository {

    Setting getSettingByKey(String keyword);
}
