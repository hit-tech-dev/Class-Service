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
  },

  USER_SUBJECT {
    @Override
    public String getSortBy(String sortBy) {
      switch (sortBy){
        case "id":
          return "cu.id";
        case "studentCode":
          return "cu.student_code";
        case "birthday":
          return "cu.birthday";
        case "fullname":
          return "cu.fullname";
        case "email":
          return "cu.email";
        case "phone":
          return "cu.phone";
        case "grade":
          return "cu.grade";
        case "gender":
          return "cu.gender";
        case "roleName":
          return "r.role_name";
        default:
          return "cu.created_date";
      }
    }
  }

}
