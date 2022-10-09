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

}