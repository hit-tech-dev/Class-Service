package com.hit.classservice.application.mapper;

import com.hit.classservice.adapter.web.v1.transfer.parameter.role.UpdateRoleParameter;
import com.hit.classservice.application.input.role.UpdateRoleInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RoleMapper {

  @Mappings({
      @Mapping(target = "id", source = "updateRoleParameter.id"),
      @Mapping(target = "name", source = "updateRoleParameter.name"),
      @Mapping(target = "description", source = "updateRoleParameter.description")
  })
  UpdateRoleInput toUpdateRoleInput(UpdateRoleParameter updateRoleParameter);

}
