package com.hit.classservice.application.interator.role;

import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.RoleRepository;
import com.hit.classservice.application.input.role.GetRoleInput;
import com.hit.classservice.application.input_boundary.role.GetRoleDataCase;
import com.hit.classservice.application.mapper.RoleMapper;
import com.hit.classservice.application.mapper.ScheduleMapper;
import com.hit.classservice.application.output.role.GetRoleOutput;
import com.hit.classservice.config.exception.NotFoundException;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Role;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationGetRoleInterator")
public class GetRoleInteractor implements GetRoleDataCase {
  private final RoleRepository roleRepository;
  private final RoleMapper roleMapper;

  public GetRoleInteractor(@Qualifier("DatabaseRoleRepository") RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
    this.roleMapper = Mappers.getMapper(RoleMapper.class);
  }

  @SneakyThrows
  @Override
  public GetRoleOutput handle(GetRoleInput input) {
    Role role = roleRepository.findById(input.getId());
    if (ObjectUtils.isEmpty(role)){
      throw new NotFoundException(UserMessageConstant.Role.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Role.ERR_NOT_FOUND_BY_ID, input.getId()),
          new String[]{input.getId().toString()});
    }
    return roleMapper.toGetRoleOutput(role);
  }
}

