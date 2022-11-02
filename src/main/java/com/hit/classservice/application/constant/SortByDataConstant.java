package com.hit.classservice.application.constant;

public enum SortByDataConstant implements SortByInterface {

  CATEGORY {
    @Override
    public String getSortBy(String sortBy) {
      switch (sortBy) {
        case "id":
          return "data_1.id";
        case "name":
          return "data_1.name";
        case "description":
          return "data_1.description";
        default:
          return "data_1.created_date";
      }
    }
  },

  SUBJECT {
    @Override
    public String getSortBy(String sortBy) {
      switch (sortBy) {
        case "id":
          return "data_1.id";
        case "name":
          return "data_1.name";
        case "description":
          return "data_1.description";
        default:
          return "data_1.created_date";
      }
    }
  }

}
