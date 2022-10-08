package com.hit.classservice.application.constant;

public class UrlConstant {

  private UrlConstant() {
  }

  public static final class Category {
    private Category() {
    }

    private static final String PREFIX = "/category";
    public static final String LIST = "categories";
    public static final String GET = PREFIX + "/{id}";
    public static final String CREATE = PREFIX;
    public static final String UPDATE = PREFIX;
    public static final String DELETE = PREFIX + "/{id}";
  }

  public static final class Comment {
    private Comment() {

    }
    private static final String PREFIX = "/comment";

    private static final String PREFIX_LESSON = PREFIX + "/lesson";
    public static final String CREATE_PARENT_FOR_LESSON = PREFIX_LESSON + "/create/parent";
    public static final String CREATE_CHILDREN_FOR_LESSON = PREFIX_LESSON + "/create/children";

    private static final String PREFIX_LESSON_STUDENT = PREFIX + "/lesson-student";
    public static final String CREATE_PARENT_FOR_LESSON_STUDENT = PREFIX_LESSON_STUDENT + "/create/parent";
    public static final String CREATE_CHILDREN_FOR_LESSON_STUDENT = PREFIX_LESSON_STUDENT + "/create/children";

  }
}
