package com.hit.classservice.application.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.SortByDataConstant;
import lombok.SneakyThrows;

import java.util.List;

public class DataUtil {
  private static final ObjectMapper objectMapper = new ObjectMapper();

  static {
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public static String standardizedSortType(String sortType) {
    if (CommonConstant.SORT_TYPE_DESC.equalsIgnoreCase(sortType)) {
      return CommonConstant.SORT_TYPE_DESC;
    }
    return CommonConstant.SORT_TYPE_ASC;
  }

  public static String standardizedSortBy(String sortBy, SortByDataConstant constant) {
    return constant.getSortBy(sortBy);
  }

  @SneakyThrows
  public static <T> T jsonToObject(String json, Class<T> clazz) {
    return objectMapper.readValue(json, clazz);
  }

  @SneakyThrows
  public static <T> List<T> jsonToLstObject(String json, Class<T> clazz) {
    JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
    return objectMapper.readValue(json, type);
  }

  @SneakyThrows
  public static String writeToJson(Object obj) {
    return objectMapper.writeValueAsString(obj);
  }

}
