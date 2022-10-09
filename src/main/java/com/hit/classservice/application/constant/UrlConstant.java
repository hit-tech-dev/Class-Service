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

  public static final class Notification {
    private Notification() {
    }
    private static final String PREFIX = "/notification";
    public static final String LIST = "notifications";
    public static final String CREATE = PREFIX;
    public static final String READ = PREFIX + "/{id}";
    public static final String GET = PREFIX + "/{id}";
    public static final String DELETE = PREFIX + "/{id}";

  }

}
