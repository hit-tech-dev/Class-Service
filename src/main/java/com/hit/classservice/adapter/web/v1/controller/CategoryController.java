package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.category.GetCategoryInput;
import com.hit.classservice.application.input.category.GetListCategoryInput;
import com.hit.classservice.application.output.category.GetCategoryOutput;
import com.hit.classservice.application.output.category.GetListCategoryOutput;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestApiV1
public class CategoryController {
  private final UseCaseBus useCaseBus;
  private final ResponseHeader responseHeader;

  public CategoryController(@Qualifier("ApplicationUseCaseBus") UseCaseBus useCaseBus,
                            @Qualifier("WebV1TransferResponseHeader") ResponseHeader responseHeader) {
    this.useCaseBus = useCaseBus;
    this.responseHeader = responseHeader;
  }

  @GetMapping(UrlConstant.Category.LIST)
  public ResponseEntity<?> getAllCategory() throws Exception {
    // Create input
    GetListCategoryInput input = new GetListCategoryInput();
    // Get output
    GetListCategoryOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @GetMapping(UrlConstant.Category.GET)
  public ResponseEntity<?> getCategoryById(@PathVariable("id") Long id) throws Exception {
    // Create input
    GetCategoryInput input = new GetCategoryInput(id);
    // Get output
    GetCategoryOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

}
