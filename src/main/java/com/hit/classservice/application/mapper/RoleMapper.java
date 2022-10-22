package com.hit.classservice.application.mapper;

import com.hit.classservice.adapter.web.v1.transfer.parameter.role.UpdateRoleParameter;
import com.hit.classservice.application.input.role.UpdateRoleInput;
import com.hit.classservice.application.output.category.GetCategoryOutput;
import com.hit.classservice.application.output.category.GetListCategoryItemOutput;
import com.hit.classservice.application.output.role.GetListRoleItemOutput;
import com.hit.classservice.application.output.role.GetRoleOutput;
import com.hit.classservice.domain.entity.Category;
import com.hit.classservice.domain.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

  @Mappings({
      @Mapping(target = "id", source = "updateRoleParameter.id"),
      @Mapping(target = "name", source = "updateRoleParameter.name"),
      @Mapping(target = "description", source = "updateRoleParameter.description")
  })
  UpdateRoleInput toUpdateRoleInput(UpdateRoleParameter updateRoleParameter);

  @Mappings({
      @Mapping(target = "id", source = "role.id"),
      @Mapping(target = "name", source = "role.name"),
      @Mapping(target = "description", source = "role.description")
  })
  GetRoleOutput toGetRoleOutput(Role role);

  GetListRoleItemOutput toGetListRoleItemOutput(Role role);

  List<GetListRoleItemOutput> toGetListRoleItemOutputs(List<Role> roles);
}
