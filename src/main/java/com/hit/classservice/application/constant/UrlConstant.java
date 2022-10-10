package com.hit.classservice.application.constant;

public class UrlConstant {

  private UrlConstant() {
  }

  public static final class Category {
    public static final String LIST = "categories";
    private static final String PREFIX = "/category";
    public static final String GET = PREFIX + "/{id}";
    public static final String CREATE = PREFIX;
    public static final String UPDATE = PREFIX;
    public static final String DELETE = PREFIX + "/{id}";

    private Category() {
    }
  }

  public static final class Subject {

    public static final String LIST = "subjects";
    private static final String PREFIX = "/subject";
    public static final String GET = PREFIX + "/{id}";
    public static final String UPDATE = PREFIX;
    public static final String DELETE = PREFIX + "/{id}";

    private Subject() {
    }
  }

  public static final class Notification {
    public static final String LIST = "notifications";
    private static final String PREFIX = "/notification";
    public static final String CREATE = PREFIX;
    public static final String READ = PREFIX + "/{id}";
    public static final String GET = PREFIX + "/{id}";
    public static final String DELETE = PREFIX + "/{id}";

    private Notification() {
    }

  }

  public static final class Comment {
    private static final String PREFIX = "/comment";
    private static final String PREFIX_LESSON = PREFIX + "/lesson";
    public static final String CREATE_PARENT_FOR_LESSON = PREFIX_LESSON + "/create/parent";
    public static final String CREATE_CHILDREN_FOR_LESSON = PREFIX_LESSON + "/create/children";
    private static final String PREFIX_LESSON_STUDENT = PREFIX + "/lesson-student";
    public static final String CREATE_PARENT_FOR_LESSON_STUDENT = PREFIX_LESSON_STUDENT + "/create/parent";
    public static final String CREATE_CHILDREN_FOR_LESSON_STUDENT = PREFIX_LESSON_STUDENT + "/create/children";

    private Comment() {

    }
  }

  public static final class Schedule {
    private static final String PREFIX = "/schedule";
    public static final String LIST = PREFIX + "s";
    public static final String GET = PREFIX + "/{id}";

    private Schedule() {
    }
  }
}
