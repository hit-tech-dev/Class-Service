package com.hit.classservice.application.interator.role;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.dai.RoleRepository;
import com.hit.classservice.application.input.role.UpdateRoleInput;
import com.hit.classservice.application.input_boundary.role.UpdateRoleDataCase;
import com.hit.classservice.application.output.role.UpdateRoleOutput;
import com.hit.classservice.domain.entity.Role;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("ApplicationUpdateRoleInterator")
public class UpdateRoleInterator implements UpdateRoleDataCase {

  private final RoleRepository roleRepository;

  public UpdateRoleInterator(@Qualifier("DatabaseRoleRepository") RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public UpdateRoleOutput handle(UpdateRoleInput input) throws Exception {
    Role oldRoleById = roleRepository.findById(input.getId());
    Role oldRoleByName = roleRepository.findByName(input.getName());
    if (ObjectUtils.isEmpty(oldRoleById)) {
      return new UpdateRoleOutput(CommonConstant.FALSE, String.format(DevMessageConstant.Role.ERR_NOT_FOUND_BY_ID,
          input.getId()));
    } else if (ObjectUtils.isNotEmpty(oldRoleByName)) {
      return new UpdateRoleOutput(CommonConstant.FALSE, String.format(DevMessageConstant.Role.NAME_IS_EXIST,
          input.getName()));
    } else {
      oldRoleById.setName(input.getName());
      oldRoleById.setDescription(input.getDescription());
      roleRepository.update(oldRoleById);
      return new UpdateRoleOutput(CommonConstant.TRUE, CommonConstant.EMPTY_STRING);

    }
  }
}