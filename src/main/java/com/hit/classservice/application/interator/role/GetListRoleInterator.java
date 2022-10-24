package com.hit.classservice.application.interator.role;

import com.hit.classservice.application.dai.RoleRepository;
import com.hit.classservice.application.input.role.GetListRoleInput;
import com.hit.classservice.application.input_boundary.role.GetListRoleDataCase;
import com.hit.classservice.application.mapper.RoleMapper;
import com.hit.classservice.application.output.role.GetListRoleItemOutput;
import com.hit.classservice.application.output.role.GetListRoleOutput;
import com.hit.classservice.domain.entity.Role;
import lombok.SneakyThrows;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ApplicationGetListRoleInterator")
public class GetListRoleInterator implements GetListRoleDataCase {
  private final RoleRepository roleRepository;
  private final RoleMapper roleMapper;

  public GetListRoleInterator(@Qualifier("DatabaseRoleRepository") RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
    this.roleMapper = Mappers.getMapper(RoleMapper.class);
  }

  @SneakyThrows
  @Override
  public GetListRoleOutput handle(GetListRoleInput input) throws Exception {
    List<Role> list = roleRepository.findAll();

    List<GetListRoleItemOutput> output = roleMapper.toGetListRoleItemOutputs(list);

    return new GetListRoleOutput(output);
  }
}
