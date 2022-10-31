package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.RestData;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.parameter.category.CreateCategoryParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.category.UpdateCategoryParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.common.PagingMetaParameter;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.category.*;
import com.hit.classservice.application.mapper.CategoryMapper;
import com.hit.classservice.application.output.category.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestApiV1
public class CategoryController {
  private final UseCaseBus useCaseBus;
  private final ResponseHeader responseHeader;
  private final CategoryMapper categoryMapper;

  public CategoryController(@Qualifier("ApplicationUseCaseBus") UseCaseBus useCaseBus,
                            @Qualifier("WebV1TransferResponseHeader") ResponseHeader responseHeader) {
    this.useCaseBus = useCaseBus;
    this.responseHeader = responseHeader;
    this.categoryMapper = Mappers.getMapper(CategoryMapper.class);
  }

  /**
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API get list category")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found the categories",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = GetListCategoryOutput.class))})
  })
  @GetMapping(UrlConstant.Category.LIST)
  public ResponseEntity<?> getAllCategory(@Valid PagingMetaParameter parameter) throws Exception {
    // Create input
    GetListCategoryInput input = categoryMapper.toGetListCategoryInput(parameter);
    // Get output
    GetListCategoryOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param id Long
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API get category by id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found the category",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = GetCategoryOutput.class))
          }),
      @ApiResponse(responseCode = "500", description = "Id not exist", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
      })
  })
  @GetMapping(UrlConstant.Category.GET)
  public ResponseEntity<?> getCategoryById(@Parameter(required = true, name = "id", description = "Id of category")
                                           @PathVariable("id") Long id) throws Exception {
    // Create input
    GetCategoryInput input = new GetCategoryInput(id);
    // Get output
    GetCategoryOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param parameter CreateCategoryParameter
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API create new category")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Create success",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = CreateCategoryOutput.class))
          })
  })
  @PostMapping(UrlConstant.Category.CREATE)
  public ResponseEntity<?> createCategory(
      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Body of request to create new category")
      @Valid @RequestBody CreateCategoryParameter parameter) throws Exception {
    // Create input
    CreateCategoryInput input = categoryMapper.toCreateCategoryInput(parameter);
    // Get output
    CreateCategoryOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param parameter UpdateCategoryParameter
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API update category")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Update success", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = UpdateCategoryOutput.class))
      }),
      @ApiResponse(responseCode = "500", description = "Id not exist", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
      })
  })
  @PutMapping(UrlConstant.Category.UPDATE)
  public ResponseEntity<?> updateCategory(
      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Body of request to update category")
      @Valid @RequestBody UpdateCategoryParameter parameter) throws Exception {
    // Create input
    UpdateCategoryInput input = categoryMapper.toUpdateCategoryInput(parameter);
    // Get output
    UpdateCategoryOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param id Long
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API delete category")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Delete success", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = DeleteCategoryOutput.class))
      }),
      @ApiResponse(responseCode = "500", description = "Id not exist", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
      })
  })
  @DeleteMapping(UrlConstant.Category.DELETE)
  public ResponseEntity<?> deleteCategory(@Parameter(description = "Id of category", required = true)
                                          @PathVariable("id") Long id) throws Exception {
    // Create input
    DeleteCategoryInput input = new DeleteCategoryInput(id);
    // Get output
    DeleteCategoryOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

}
