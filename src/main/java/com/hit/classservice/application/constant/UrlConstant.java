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
    public static final String CREATE = PREFIX;

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
    private static final String LIST = "/comments";
    private static final String LIST_PARENT = LIST + "/parent";
    private static final String LIST_CHILDREN = LIST + "/children";

    private static final String PREFIX = "/comment";

    private static final String PREFIX_PARENT = PREFIX + "/parent";
    private static final String PREFIX_CHILDREN = PREFIX + "/children";
    private static final String LESSON = "/lesson";
    private static final String LESSON_STUDENT = "/lesson-student";

    public static final String GET_PARENT_BY_LESSON = LIST_PARENT + LESSON + "/{lessonId}";
    public static final String GET_CHILDREN_BY_LESSON = LIST_CHILDREN + LESSON + "/{lessonId}/{parentId}";

    public static final String CREATE_PARENT_FOR_LESSON = PREFIX_PARENT + LESSON;
    public static final String CREATE_CHILDREN_FOR_LESSON = PREFIX_CHILDREN + LESSON;
    public static final String CREATE_PARENT_FOR_LESSON_STUDENT = PREFIX_PARENT + LESSON_STUDENT;
    public static final String CREATE_CHILDREN_FOR_LESSON_STUDENT = PREFIX_CHILDREN + LESSON_STUDENT;

    public static final String DELETE = PREFIX + "/{id}";
    public static final String EDIT = PREFIX;

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

  public static final class Lesson {

    public static final String LIST = "lessons";
    private static final String PREFIX = "/lesson";
    public static final String GET_LESSON_BY_SUBJECT = PREFIX + "/{subjectId}";
    public static final String UPDATE = PREFIX;

    private Lesson() {
    }
  }
}
