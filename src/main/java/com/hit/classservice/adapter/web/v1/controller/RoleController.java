package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.parameter.role.UpdateRoleParameter;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.role.GetListRoleInput;
import com.hit.classservice.application.input.role.GetRoleInput;
import com.hit.classservice.application.input.role.UpdateRoleInput;
import com.hit.classservice.application.mapper.RoleMapper;
import com.hit.classservice.application.output.role.GetListRoleOutput;
import com.hit.classservice.application.output.role.GetRoleOutput;
import com.hit.classservice.application.output.role.UpdateRoleOutput;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RestApiV1
public class RoleController {
  private final RoleMapper roleMapper;
  private final UseCaseBus useCaseBus;
  private final ResponseHeader responseHeader;

  public RoleController(UseCaseBus useCaseBus, ResponseHeader responseHeader) {
    this.useCaseBus = useCaseBus;
    this.responseHeader = responseHeader;
    this.roleMapper = Mappers.getMapper(RoleMapper.class);
  }

  @PutMapping(UrlConstant.Role.UPDATE)
  public ResponseEntity<?> editRoleById(@Valid @RequestBody UpdateRoleParameter updateRoleParameter) throws Exception {
    //Create input
    UpdateRoleInput input = roleMapper.toUpdateRoleInput(updateRoleParameter);
    //Get output
    UpdateRoleOutput output = useCaseBus.handle(input);
    //return
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @GetMapping(UrlConstant.Role.GET)
  public ResponseEntity<?> getRoleById(@PathVariable Long id) throws Exception {
    GetRoleInput input = new GetRoleInput(id);

    GetRoleOutput output = useCaseBus.handle(input);

    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @GetMapping(UrlConstant.Role.LIST)
  public ResponseEntity<?> getAllRole() throws Exception {
    GetListRoleInput input = new GetListRoleInput();

    GetListRoleOutput output = useCaseBus.handle(input);

    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

}
