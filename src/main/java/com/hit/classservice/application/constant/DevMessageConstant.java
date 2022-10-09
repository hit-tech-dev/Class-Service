package com.hit.classservice.application.constant;

public class DevMessageConstant {
  private DevMessageConstant() {
  }

  public static final class Category {
    public static final String ERR_NOT_FOUND_BY_ID = "Not found category by id = %s";
    public static final String NAME_IS_EXIST = "Category with name '%s' is exist";
    public static final String DUPLICATE_NAME = "Duplicate category name '%s'";
  }

  public static final class Lesson {
    public static final String ERR_NOT_FOUND_BY_ID = "Not found lesson by id = %s";
  }

  public static final class LessonStudent {
    public static final String ERR_NOT_FOUND_BY_ID = "Not found lesson student by id = %s";
  }

  public static final class Comment {
    public static final String ERR_NOT_FOUND_BY_ID = "Not found comment by id = %s";
  }

}
